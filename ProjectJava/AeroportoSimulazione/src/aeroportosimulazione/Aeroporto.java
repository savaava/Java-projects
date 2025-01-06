package aeroportosimulazione;

import java.util.Map;
import java.util.LinkedHashMap;
import java.io.*;

public class Aeroporto implements java.io.Serializable{
    private final CodeChecker checker;
    private final Map<String, Aeromobile> aeroporto;
    
    public Aeroporto(CodeChecker checker){
        this.checker = checker;
        aeroporto = new LinkedHashMap<>();
    }
    
    public boolean inserisci(Aeromobile a){
        if(checker == null){
            aeroporto.putIfAbsent(a.getCodice(),a);
            return true;
        }
        if(checker.check(a.getCodice())){
            aeroporto.putIfAbsent(a.getCodice(),a);
            return true;
        }
        return false;
    }    
    public Aeromobile cerca(String codice){
        return aeroporto.get(codice);
    }    
    public Aeromobile rimuovi(String codice){
        return aeroporto.remove(codice);
    }    
    public int elementi(){
        return aeroporto.size();
    }
    
    /* Formato file binario:
    -- byte: 0->null 1->CodeCheckerIT || 2->CodeCheckerEN
    -- #Aeromobili
    - codice
    - bit: 1->AereoAMotore || 0->Aliante
    - numRotori || efficienza
    - ...
    */
    public void salvaDOS(String nomefile){
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
            if(checker == null)
                dos.writeByte(0);
            else if(checker.getClass() == CodeCheckIT.class)
                dos.writeByte(1);
            else
                dos.writeByte(2);
            
            dos.writeInt(elementi());
            
            for(Aeromobile ai : aeroporto.values()){
                dos.writeUTF(ai.getCodice());
                if(ai.getClass() == AereoAMotore.class){
                    dos.writeBoolean(true);
                    AereoAMotore tmp = (AereoAMotore)ai;
                    dos.writeInt(tmp.getNumRotori());
                }else{
                    dos.writeBoolean(false);
                    Aliante tmp = (Aliante)ai;
                    dos.writeDouble(tmp.getEfficienza());
                }
            }
            
        }catch(IOException ex){ex.printStackTrace();}
    }    
    public static Aeroporto leggiDIS(String nomefile){
        Aeroporto aLetto = null;
        
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            byte b = dis.readByte();
            if(b == 0)
                aLetto = new Aeroporto(null);
            else if(b==1)
                aLetto = new Aeroporto(new CodeCheckIT());
            else 
                aLetto = new Aeroporto(new CodeCheckEN());
            
            int numAeromobili = dis.readInt();
            for(int i=0; i<numAeromobili; i++){
                String codice = dis.readUTF();
                Aeromobile ai = null;
                if(dis.readBoolean()){
                    ai = new AereoAMotore(codice, dis.readInt());
                }else{
                    ai = new Aliante(codice, dis.readDouble());
                }
                aLetto.inserisci(ai);
            }
            
        }catch(IOException ex){ex.printStackTrace();}
        
        return aLetto;
    }
    
    public void salvaOBJ(String nomefile){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
            oos.writeObject(this);
        }catch(IOException ex){ex.printStackTrace();}
    }
    public static Aeroporto leggiOBJ(String nomefile){
        Aeroporto aLetto = null;
        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            try{
                aLetto = (Aeroporto)ois.readObject();
            }catch(ClassNotFoundException ex){ex.printStackTrace();}
        }catch(IOException ex){ex.printStackTrace();}
        
        return aLetto;
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        for(Aeromobile ai : aeroporto.values())
            strb.append(ai).append("\n");
        
        return strb.toString();
    }
}
