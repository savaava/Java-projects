package it.unisa.diem.oop.threadgestioneristorante;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Comande {
    Queue<Ordinazione> comande;
    private String filename;
    
    public Comande(String filename, Boolean leggiBackup) throws IOException {
        this.filename = filename;
        comande = null;
        if(leggiBackup){
            try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
                try{
                    comande = new LinkedList<>((Collection<Ordinazione>)ois.readObject());
                }catch(ClassNotFoundException ex){ex.printStackTrace();}
            }
        }else{
            comande = new LinkedList<>();
        }
    }
    
    public synchronized void aggiungiOrdinazione(Ordinazione ordinazione){
        comande.add(ordinazione);
        notifyAll();
    }
    
    public synchronized Ordinazione consegnaOrdinazione() {
        if(comande.isEmpty()){
            try{wait();}
            catch(InterruptedException ex){ex.printStackTrace();}
        }
        notifyAll();
        return comande.remove();
        /* il mutex viene comunque rilasciato quanto termina il blocco synchronized quindi il metodo */
    }
    
    public synchronized void salvaOrdinazioni() {
        if(comande.isEmpty()){
            try{wait();}
            catch(InterruptedException ex){ex.printStackTrace();}
        }
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            oos.writeObject(comande);
        }catch(IOException ex){ex.printStackTrace();}
        
        notifyAll();
    }
}
