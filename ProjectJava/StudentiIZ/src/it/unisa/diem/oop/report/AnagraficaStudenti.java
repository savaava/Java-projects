package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
}
