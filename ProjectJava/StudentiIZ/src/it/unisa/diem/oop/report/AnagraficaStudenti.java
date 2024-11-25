package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AnagraficaStudenti {
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
    
    /* voglio salvare su un file */
    public void salvaDOS(String nomeFile) throws /*FileNotFoundException,*/ IOException{
        /* dobbiamo gestire l'eccezione se non mi fa creare il file ed è fuori dal
        controllo. non lo riesco a crare quindi non esiste FileNotFoundException */
        FileOutputStream fos = new FileOutputStream(nomeFile);
        
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        
        //fos.write(); no
        DataOutputStream dos = new DataOutputStream(bos);
        /* così lego il decoratore al componente concreto
        in questo modo svincolo il componente concreto dalle decorazioni,
        infatti potrebbe essere FileOutputStream o URLOutputStream
        le varie funzionalità write di dos utilizzano il write di FileOutputStream */
        dos.writeUTF(descrizione); /* perchè in cima voglio la descrizione */
        /* ora devo gestire un'altra eccezione IOException che è più generale quindi 
        possiamo togliere FileNotFoundException*/
        
        for(Studente s : anagrafica.values()){
            dos.writeUTF(s.getNome());
            dos.writeUTF(s.getCognome());
            dos.writeUTF(s.getCodiceFiscale());
            dos.writeUTF(s.getMatricola());
            dos.writeFloat(s.getVotoMedio());
        }
        
        System.out.println("*****Scrittura completata*****");
        /* se io chiudo dos chiudo anche fos: */
        dos.close();
    }
    
    /* con un metodo statico io posso leggere un anagrafica prima di istanziarne una */
    public static AnagraficaStudenti leggiDOS(String nomeFile) throws IOException{
        //DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomeFile)));
        
        FileInputStream fis = new FileInputStream(nomeFile);
        
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
            System.out.println("*****Lettura completata*****");
        }finally{
            dis.close();
        }
        return a;
    }
    
    public void salvaCSV(String nomefile)throws IOException{
        /* posso salvare il nome dell'anagrafica, però i campi in un file csv sono convenzionalmente
        separati da uno spazio o ; */
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))){
            /* sulla prima riga ci devono essere i nomi delle colonne OPPURE direttamente gli oggetti */
            pw.println("NOME;COGNOME;CODICE FISCALE;MATRICOLA;VOTOMEDIO");
            /* i campi intermedi sono separati da ; ma non necessariamente devo metterlo anche alla fine */
            for(Studente si : anagrafica.values()){
                pw.append(si.getNome()).append(";");
                pw.append(si.getCognome()).append(";");
                pw.append(si.getCodiceFiscale()).append(";");
                pw.append(si.getMatricola()).append(";");
                /* classe wrapper per il voto */
                pw.append(""+si.getVotoMedio()).append("\n");
            }
        }
    }
    /* per la lettura csv */
    public static AnagraficaStudenti leggiCSV(String nomefile) throws IOException{
        String nome = nomefile.split("[.]")[0]; /* oppure \\. */
        AnagraficaStudenti a = new AnagraficaStudenti(nome);
        try(BufferedReader br = new BufferedReader(new FileReader(nomefile))){
            if(br.readLine() == null) return a; /* perchè la prima linea è solo descrittiva delle colonne */
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
            /* ci scansioniamo un token per volta */
            scan.useDelimiter("[;\n]");
            scan.useLocale(Locale.US); 
            /*è importante impostare la localizzazione vedendo il voto medio 28.5 se c'è
            il punto allora è EN, quindi è sbagliato scrivere Locale.ITALY si deve mettere US*/
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


