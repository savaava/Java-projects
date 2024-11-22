package simulazioneaeroportoio;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Aeroporto {
    private final CodeChecker checker;
    private final Map<String,Aeromobile> aeroporto;
    
    public Aeroporto(CodeChecker checker){
        this.checker = checker;
        aeroporto = new HashMap<>();
    }
    
    public boolean inserisci(Aeromobile a){
        if(checker.check(a.getCodice())){
            aeroporto.putIfAbsent(a.getCodice(), a);
            return true;
        }
        return false;
    }
    
    public Aeromobile cerca(String codice) throws CloneNotSupportedException{
        Aeromobile aTmp = aeroporto.get(codice);
        if(aTmp == null)
            return null;
        return (Aeromobile)aTmp.clone();
    }
    
    public Aeromobile rimuovi(String codice) throws CloneNotSupportedException{
        Aeromobile aTmp = aeroporto.remove(codice);
        if(aTmp == null)
            return null;
        return (Aeromobile)aTmp.clone();
    }
    
    public int elementi(){
        return Aeromobile.getCont();
    }
    
    public void salvaDOS(String nomeFile) throws IOException{
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomeFile)));
        for(Aeromobile ai : aeroporto.values()){
            dos.writeUTF(ai.getCodice());
            dos.writeInt(ai.getNumeroSequenziale());
            if(ai.getClass() == Aliante.class){
                Aliante aiTmp = (Aliante)ai;
                dos.writeDouble(aiTmp.getEfficienza());
            }else {
                AereoAMotore aiTmp = (AereoAMotore)ai;
                dos.writeDouble(aiTmp.getNumRotori());
            }
        }
        System.out.println("*****Scrittura completata*****");
        dos.close();
    }
    
    public static Aeroporto leggiDIS(String nomefile){
        
    }
    
    public void salvaOBJ(String nomefile){
        
    }
    
    public static Aeroporto leggiOBJ(String nomefile){
        
    }
    
    @Override
    public String toString(){
        String strTmp = "\nSono stati effettuati n."+Aeromobile.getCont()+"\nElementi inseriti:\n";
        StringBuffer strb = new StringBuffer(strTmp);
        
        for(Aeromobile ai : aeroporto.values()){
            strb.append(ai).append("\n");
        }
        
        return strb.toString();
    }
}
