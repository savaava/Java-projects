package provaio;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.io.*;

import java.util.Scanner;
import java.util.Locale;

public class TestAllDecorators {
    private final static String filename = "ElencoPersone";
    
    private static boolean checkMaps(Map<String,Persona> m1, Map<String,Persona> m2) {
        if(m1 == null || m2 == null) return false;
        if(m1.size() != m2.size()) return false;
        
        Iterator<Map.Entry<String,Persona>> it1 = m1.entrySet().iterator();
        Iterator<Map.Entry<String,Persona>> it2 = m2.entrySet().iterator();
        
        while(it1.hasNext() && it2.hasNext()){
            Map.Entry<String,Persona> e1 = it1.next();
            Map.Entry<String,Persona> e2 = it2.next();
            if(!e1.getKey().equals(e2.getKey()) || !e1.getValue().equals(e2.getValue()))
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        Persona v[] = {
            new Persona("Mario", "Rossi", "SRSTI098",12, 1.9f),
            new Persona("Giggi", "Arancio", "IUYABSDAS",55, 1.6f),
            new Persona("Carlo", "Grigio", "UYUEQYUIW",91, 1.4f),
            new Persona("Bison", "Purple", "ADIUCAA",20, 2.5f),
            new Persona("Zolute", "Vedi", "5A2831SAD",22, 1.7f)};
        
//        Map<String, Persona> persone = new TreeMap<>((o1,o2) -> {
//            return o2.compareToIgnoreCase(o1);
//        });
        /* comparatore con funzione lambda non è serializzabile
        o classe anonima dell'interfaccia Comparator<String>,
        quindi: */
        Map<String, Persona> persone = new TreeMap<>(new ComparatoreGis());

        for(Persona pi : v)
            persone.put(pi.getCodiceFiscale(), pi);
        
        String delim = "----------------------------------------------------\n";
        System.out.println("Elenco da scrivere: \n"+persone+"\n"+delim);
        
        
        /* FORMATO:
        - nome (UTF)
        - cognome (UTF)
        - cf (UTF)
        - età (Int)
        - altezza (Float)
        */
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename+".bin")))){
            for(Persona pi : persone.values()){
                dos.writeUTF(pi.getNome());
                dos.writeUTF(pi.getCognome());
                dos.writeUTF(pi.getCodiceFiscale());
                dos.writeInt(pi.getEta());
                dos.writeFloat(pi.getAltezza());
            }
        }
        Map<String, Persona> persone1 = new TreeMap<>(new ComparatoreGis());
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename+".bin")))){
            try{
                while(true){
                    String nome = dis.readUTF();
                    String cognome = dis.readUTF();
                    String cf = dis.readUTF();
                    int eta = dis.readInt();
                    float alt = dis.readFloat();
                    
                    persone1.put(cf, new Persona(nome, cognome, cf, eta, alt));
                }
            }catch(EOFException ex){}
        }
        System.out.println("Elenco letto (DataInputStream): \n"+persone1+"\n"+(checkMaps(persone,persone1)?"(Corretto)":"(NonCorretto)")+delim);
        
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename+".ser")))){
            oos.writeObject(persone);
        }
        Map<String, Persona> persone2 = null;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename+".ser")))){
            try{persone2 = (Map<String, Persona>)ois.readObject();}
            catch(ClassNotFoundException ex){}
        }
        System.out.println("Elenco letto (ObjectInputStream): \n"+persone2+"\n"+(checkMaps(persone,persone2)?"(Corretto)":"(NonCorretto)")+delim);
        
        
        /* FORMATO:
        NOME|COGNOME|CF|ETA|ALTEZZA
        nome|cognome|cf|eta|altezza \n
        nome|cognome|cf|eta|altezza
        ...
        */
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename+".csv")))){
            pw.println("NOME|COGNOME|CF|ETA|ALTEZZA");
            for(Persona pi : persone.values()){
                pw.append(pi.getNome()).append("|");
                pw.append(pi.getCognome()).append("|");
                pw.append(pi.getCodiceFiscale()).append("|");
                pw.append(Integer.toString(pi.getEta())).append("|");
                pw.append(Float.toString(pi.getAltezza())).append("\n");
            }
        }
        Map<String, Persona> persone3 = new TreeMap<>(new ComparatoreGis());
        try(BufferedReader br = new BufferedReader(new FileReader(filename+".csv"))){
            br.readLine();
            String line = br.readLine();
            while(line != null){
                String tokens[] = line.split("[|]");
                Persona pi = new Persona(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),Float.parseFloat(tokens[4]));
                persone3.put(pi.getCodiceFiscale(), pi);
                line = br.readLine();
            }
        }
        System.out.println("Elenco letto (BufferedReader): \n"+persone3+"\n"+(checkMaps(persone,persone3)?"(Corretto)":"(NonCorretto)")+delim);
        Map<String, Persona> persone4 = new TreeMap<>(new ComparatoreGis());
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename+".csv")))){
            scan.nextLine();
            scan.useDelimiter("[|\n]");
            scan.useLocale(Locale.US);
            while(scan.hasNext()){
                String nome = scan.next();
                String cognome = scan.next();
                String cf = scan.next();
                int eta = scan.nextInt();
                float alt = scan.nextFloat();
                
                persone4.put(cf, new Persona(nome, cognome, cf, eta, alt));
            }
        }
        System.out.println("Elenco letto (BufferedReader): \n"+persone4+"\n"+(checkMaps(persone,persone4)?"(Corretto)":"(NonCorretto)")+delim);
    }    
}
