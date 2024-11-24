package simulazioneaeroportoio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Aeroporto implements Serializable {
    private final CodeChecker checker;
    private final Map<String,Aeromobile> aeroporto;
    
    public Aeroporto(CodeChecker checker){
        this.checker = checker;
        aeroporto = new LinkedHashMap<>();
    }
    
    public boolean inserisci(Aeromobile a){
        if(checker == null){
            aeroporto.putIfAbsent(a.getCodice(), a);
            return true;
        }
        if(checker.check(a.getCodice())){
            aeroporto.putIfAbsent(a.getCodice(), a);
            return true;
        }
        return false;
    }
    
    public Aeromobile cerca(String codice) {
        Aeromobile aTmp = aeroporto.get(codice);
        if(aTmp == null)
            return null;
        try {
            return (Aeromobile)aTmp.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Aeromobile rimuovi(String codice) {
        Aeromobile aTmp = aeroporto.remove(codice);
        if(aTmp == null)
            return null;
        try {
            Aeromobile out = (Aeromobile)aTmp.clone();
            Aeromobile.cont--;
            return out;
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public int elementi(){
        return aeroporto.size();
    }
    
    /* Metodi per I/O streams */
    /* SCHEMA DI SALVATAGGIO
    
    */
    public void salvaDOS(String nomeFile) {
        System.out.println("**********Scrittura Iniziata**********");
        /* try catch with resources */
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomeFile)))){
            if(checker == null){
                dos.writeUTF("NO CodeChecker");
            }else if(checker.getClass() == CodeCheckIT.class){
                dos.writeUTF("CodeCheckerIT");
            }else{
                dos.writeUTF("CodeCheckerEN");
            }
            
            dos.writeInt(elementi());
            System.out.println("aeromobili da scrivere sul file: "+elementi());
            
            for(Aeromobile ai : aeroporto.values()){
                    dos.writeUTF(ai.getCodice());
                if(ai.getClass() == Aliante.class){
                    System.out.println("Scrittura Aliante...");
                    dos.writeUTF("Aliante");
                    Aliante aiTmp = (Aliante)ai;
                    dos.writeDouble(aiTmp.getEfficienza());
                }else{ /* se ai è di tipo AereoAMotore */
                    System.out.println("Scrittura Aereo a motore...");
                    dos.writeUTF("Aereo a motore");
                    AereoAMotore aiTmp = (AereoAMotore)ai;
                    dos.writeInt(aiTmp.getNumRotori());
                }
            }
            
            System.out.println("**********Scrittura completata**********\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("**********Scrittura NON completata**********\n");
        }
    }
    
    public static Aeroporto leggiDIS(String nomefile){
        Aeroporto aeroportoLetto = null;
        System.out.println("**********Lettura Iniziata**********");
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            String strIniziale = dis.readUTF();
            CodeChecker c;
            if(strIniziale.equals("NO CodeChecker")){
                c = null;
            }else if(strIniziale.equals("CodeCheckerIT")){
                c = new CodeCheckIT();
            }else{
                c = new CodeCheckEN();
            }            
            aeroportoLetto = new Aeroporto(c);
            
            int numAeromobili = dis.readInt();
            System.out.println("aeromobili da leggere dal file: "+numAeromobili);
            
            String cod;
            String controlloTipoAeromobile;
            /* conosco il numero di aeromobili perchè in scrittura inserisco tale informazione */
            for(int i=1; i<=numAeromobili; i++){
                cod = dis.readUTF();
                controlloTipoAeromobile = dis.readUTF();
                if(controlloTipoAeromobile.equals("Aliante")){  
                    System.out.println("lettura Aliante...");
                    aeroportoLetto.inserisci(new Aliante(cod,dis.readDouble()));
                }else{
                    System.out.println("lettura Aereo a motore...");
                    aeroportoLetto.inserisci(new AereoAMotore(cod,dis.readInt()));
                }
            }
            
            System.out.println("**********Lettura completata**********\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("**********Lettura NON completata**********\n");
        }
        return aeroportoLetto;
    }
    
    /* Aeromobile implements Serializable */
//    public void salvaOBJ(String nomefile){
//        System.out.println("**********Scrittura Serializzata Iniziata**********");
//        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
//            if(checker == null){
//                oos.writeUTF("NO CodeChecker");
//            }else if(checker.getClass() == CodeCheckIT.class){
//                oos.writeUTF("CodeCheckerIT");
//            }else{
//                oos.writeUTF("CodeCheckerEN");
//            }
//            
//            oos.writeInt(elementi());
//            System.out.println("aeromobili da scrivere sul file: "+elementi());
//            
//            for(Aeromobile ai : aeroporto.values()){
//                oos.writeObject(ai);
//            }
//            System.out.println("**********Scrittura Serializzata completata**********\n");
//        }catch(IOException ex){
//            System.out.println(ex.getMessage());
//            System.out.println("**********Scrittura Serializzata NON completata**********\n");
//        }
//    }
//    
//    public static Aeroporto leggiOBJ(String nomefile){
//        Aeroporto aeroportoLetto = null;
//        System.out.println("**********Lettura con Deserializzazione Iniziata**********");
//        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
//            String strIniziale = ois.readUTF();
//            if(strIniziale.equals("NO CodeChecker")){
//                aeroportoLetto = new Aeroporto(null);
//            }else if(strIniziale.equals("CodeCheckerIT")){
//                aeroportoLetto = new Aeroporto(new CodeCheckIT());
//            }else{
//                aeroportoLetto = new Aeroporto(new CodeCheckEN());
//            }
//            
//            int numAeromobili = ois.readInt();
//            System.out.println("aeromobili da leggere dal file serializzato: "+numAeromobili);
//            for(int i=1; i<=numAeromobili; i++){
//                try {
//                    aeroportoLetto.inserisci((Aeromobile)ois.readObject());
//                } catch (ClassNotFoundException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//            
//            System.out.println("**********Lettura con Deserializzazione completata**********\n");
//        }catch(IOException ex){
//            System.out.println(ex.getMessage());
//            System.out.println("**********Lettura con Deserializzazione NON completata**********\n");
//        }
//        
//        return aeroportoLetto;
//    }
    
    public void salvaOBJ(String nomefile){
        System.out.println("**********Scrittura Serializzata Iniziata**********");
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
            oos.writeObject(this);
            System.out.println("**********Scrittura Serializzata completata**********\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("**********Scrittura Serializzata NON completata**********\n");
        }
    }
    
    public static Aeroporto leggiOBJ(String nomefile){
        Aeroporto aeroportoLetto = null;
        System.out.println("**********Lettura con Deserializzazione Iniziata**********");
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            try {
                aeroportoLetto = (Aeroporto)ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("**********Lettura con Deserializzazione completata**********\n");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("**********Lettura con Deserializzazione NON completata**********\n");
        }
        return aeroportoLetto;
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("Aeroporto ");
        if(checker == null){
            strb.append("senza CodeChecker\n");
        }else if(checker.getClass() == CodeCheckIT.class){
            strb.append("con CodeCheckerIT\n");
        }else{
            strb.append("con CodeCheckerEN\n");
        }
        
        for(Aeromobile ai : aeroporto.values()){
            strb.append(ai).append("\n");
        }
        
        return strb.toString();
    }
}
