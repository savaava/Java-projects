package provaio;

import java.io.*;
import java.util.*;

public class ProvaIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persone[] = {
            new Persona("Mario", "Rossi", "SRSTI098",12),
            new Persona("Giggi", "Arancio", "IUYABSDAS",55),
            new Persona("Carlo", "Grigio", "UYUEQYUIW",91),
            new Persona("Bison", "Purple", "ADIUCAA",20),
            new Persona("Zolute", "Vedi", "5A2831SAD",22)};
        
        Map<String, Persona> elenco = new HashMap<>();
        elenco.put(persone[0].getCodiceFiscale(), persone[0]);
        elenco.put(persone[1].getCodiceFiscale(), persone[1]);
        elenco.put(persone[2].getCodiceFiscale(), persone[2]);
        elenco.put(persone[3].getCodiceFiscale(), persone[3]);
        elenco.put(persone[4].getCodiceFiscale(), persone[4]);
        
        
        
        String filename = "ElencoFile";
        /* Formato file binario:
        - NumeroPersone (int)
        - NomePersona1 (UTF)
        - CognomePersona1 (UTF)
        - CFPersona1 (UTF)
        - etaPersona1 (int)
        */
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename+"NoSer.bin")))){
            dos.writeInt(elenco.size());
            for(Persona pi : elenco.values()){
                dos.writeUTF(pi.getNome());
                dos.writeUTF(pi.getCognome());
                dos.writeUTF(pi.getCodiceFiscale());
                dos.writeInt(pi.getEta());
            }
        }
        System.out.println("Elenco Scritto (DataOutputStream):\n"+elenco);
        
        Map<String, Persona> elencoLetto1 = new HashMap<>();
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename+"NoSer.bin")))){
            int numPersone = dis.readInt();
            for(int i=0; i<numPersone; i++){
                String nomeLetto = dis.readUTF();
                String cognomeLetto = dis.readUTF();
                String cfLetto = dis.readUTF();
                int etaLetta = dis.readInt();
                
                elencoLetto1.put(cfLetto, new Persona(nomeLetto, cognomeLetto, cfLetto, etaLetta));
            }
        }
        System.out.println("Elenco Letto (DataInputStream) "+(elencoLetto1.equals(elenco)?"corretto":"nonCorretto")+":\n"+elencoLetto1+"\n");
        
        
        /* Formato file binario serializzato:
        - elencoPersone
        */
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename+"Ser.bin")))){
            oos.writeObject(elenco);
        }
        System.out.println("Elenco Scritto (ObjectOutputStream):\n"+elenco);
        
        Map<String, Persona> elencoLetto2;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename+"Ser.bin")))){
            elencoLetto2 = (Map<String, Persona>)ois.readObject();
        }
        System.out.println("Elenco Letto (ObjectInputStream) "+(elencoLetto2.equals(elenco)?"corretto":"nonCorretto")+":\n"+elencoLetto2+"\n");
        
        
        
        /* Formato file binario:
        NOME;COGNOME;CF;ETA
        Mario;Rossi;SRSTI098;12
        ...
        */
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename+".csv")))){
            pw.println("NOME;COGNOME;CF;ETA");
            for(Persona pi : elenco.values()){
                pw.append(pi.getNome()).append(";");
                pw.append(pi.getCognome()).append(";");
                pw.append(pi.getCodiceFiscale()).append(";");
                pw.append(Integer.toString(pi.getEta())).append("\n");
            }
        }
        System.out.println("Elenco Scritto (PrintWriter):\n"+elenco);
        
        Map<String, Persona> elencoLetto3 = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename+".csv"))){
            br.readLine();
            
            String line;
            while((line=br.readLine())!=null){
                String valori[] = line.split(";");
                elencoLetto3.put(valori[2], new Persona(valori[0],valori[1],valori[2],Integer.parseInt(valori[3])));
            }
        }
        System.out.println("Elenco Letto (BufferedReader) "+(elencoLetto3.equals(elenco)?"corretto":"nonCorretto")+":\n"+elencoLetto3);
        
        Map<String, Persona> elencoLetto4 = new HashMap<>();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename+".csv")))){
            scan.nextLine();
            scan.useDelimiter("[;\n]");
            while(scan.hasNext()){
                String nome = scan.next();
                String cogn = scan.next();
                String cf   = scan.next();
                int eta = scan.nextInt();
                elencoLetto4.put(cf, new Persona(nome, cogn, cf, eta));
            }
        }
        System.out.println("Elenco Letto (BufferedReader) "+(elencoLetto4.equals(elenco)?"corretto":"nonCorretto")+":\n"+elencoLetto4);
    }
}
