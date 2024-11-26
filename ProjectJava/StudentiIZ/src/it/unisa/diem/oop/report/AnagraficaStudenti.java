package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AnagraficaStudenti implements Serializable {
    private String descrizione; 
    private Map<String,Studente> anagrafica;
    
    public AnagraficaStudenti(String descrizione){
        this.descrizione = descrizione;
        anagrafica = new HashMap<>();
    }
    
    public void aggiungi(Studente s){
        anagrafica.putIfAbsent(s.getMatricola(), s);
    }
    
    public Studente cerca(String matricola){
        return anagrafica.get(matricola);
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("Anagrafica: ");
        strb.append(descrizione).append("\n");
        
        for(Studente s : anagrafica.values()){
            strb.append(s).append("\n");
        }
        
        return strb.toString();
    }
    
    public void salvaDOS(String nomefile) throws /*FileNotFoundException,*/ IOException{
        FileOutputStream fos = new FileOutputStream(nomefile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeUTF(descrizione);
        
        for(Studente s : anagrafica.values()){
            dos.writeUTF(s.getNome());
            dos.writeUTF(s.getCognome());
            dos.writeUTF(s.getCodiceFiscale());
            dos.writeUTF(s.getMatricola());
            dos.writeFloat(s.getVotoMedio());
        }
        
        System.out.println("\n*****Scrittura completata*****");
        /* se io chiudo dos chiudo anche fos: */
        dos.close();
    }    
    public static AnagraficaStudenti leggiDOS(String nomefile) throws IOException{
        //DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile)));
        
        FileInputStream fis = new FileInputStream(nomefile);
        
        BufferedInputStream bis = new BufferedInputStream(fis);
        /* ora il file viene letto in modo che più byte vengono letti */
        
        DataInputStream dis = new DataInputStream(bis);
        
        String descrizione = dis.readUTF();
        AnagraficaStudenti a = new AnagraficaStudenti(descrizione); 
        /* nel processo di lettura dovremmo avere un modo di capire quando terminare il ciclo
        se non abbiao un numero nel file di fianco alla descrizione allora facciamo while true: */
        try{            
            while(true){
                String nome = dis.readUTF();
                String cognome = dis.readUTF();
                String codFiscale = dis.readUTF();
                String matricola = dis.readUTF();
                float votoM = dis.readFloat();
                
                a.aggiungi(new Studente(nome,cognome,codFiscale,matricola,votoM));
            }
        }catch(EOFException ex){
            System.out.println("*****Lettura completata*****\n");
        }finally{
            dis.close();
        }
        return a;
    }
    
    public void salvaOBJ(String nomefile) throws IOException {
        System.out.println("*****Scrittura con Serializzazione iniziata*****");
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
            oos.writeObject(this);
            System.out.println("*****Scrittura con Serializzazione completata*****");
        }
    }    
    public static AnagraficaStudenti leggiOBJ(String nomefile) throws IOException{
        System.out.println("*****Lettura con DeSerializzazione iniziata*****");
        
        AnagraficaStudenti anagraficaLetta = null;        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            try{
                anagraficaLetta = (AnagraficaStudenti)ois.readObject();
            }catch(ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("*****Lettura con DeSerializzazione completata*****");
        }        
        return anagraficaLetta;
    }
    
    public void salvaCSV(String nomefile)throws IOException{
        System.out.println("*****Scrittura CSV iniziata*****");
        
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))){
            pw.println("NOME;COGNOME;CODICE FISCALE;MATRICOLA;VOTOMEDIO");
            
            for(Studente si : anagrafica.values()){
                pw.append(si.getNome()).append(";");
                pw.append(si.getCognome()).append(";");
                pw.append(si.getCodiceFiscale()).append(";");
                pw.append(si.getMatricola()).append(";");
                Float voto = si.getVotoMedio();
                pw.append(voto.toString()).append("\n");
            }
            System.out.println("*****Scrittura CSV completata*****");
        }
    }
    public static AnagraficaStudenti leggiCSV(String nomefile) throws IOException{
        String nome = nomefile.split("[.]")[0]; /* oppure \\. */
        AnagraficaStudenti a = new AnagraficaStudenti(nome);
        try(BufferedReader br = new BufferedReader(new FileReader(nomefile))){
            if(br.readLine() == null) return a;
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Studente s = new Studente(campi[0],campi[1],campi[2],campi[3],Float.parseFloat(campi[4]));
                a.aggiungi(s);
            }
        }        
        return a;
    }
    public static AnagraficaStudenti leggiCSVScan(String nomefile) throws IOException{
        String nomef = nomefile.split("[.]")[0];
        AnagraficaStudenti a = new AnagraficaStudenti(nomef);
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(nomefile)))){
            if(scan.nextLine()== null) return a;
            scan.useDelimiter("[;\n]");
            scan.useLocale(Locale.US);
            while(scan.hasNext()){
                /* non mi serve il controllo campo per campo perchè già so com'è strutturato il file 
                con if(hasNext), if(hasNextFloat), questo però serve quando il file potrebbe essere
                variabile ad esempio il campo float potrebbe mancare, oppure con un try interno */
                String nome = scan.next();
                String cognome = scan.next();
                String codFis = scan.next();
                String matricola = scan.next();
                float votoMedio = scan.nextFloat();                
                a.aggiungi(new Studente(nome, cognome, codFis, matricola, votoMedio));
            }
        }
        return a;
    }
}


