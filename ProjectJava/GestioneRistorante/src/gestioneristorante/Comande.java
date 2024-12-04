package gestioneristorante;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Comande {
    private final String filename;
    private LinkedList<Ordinazione> ordinazioni = null;

    public Comande(String filename, Boolean leggiBackup) {
        this.filename = filename;
        if(!leggiBackup){
            ordinazioni = new LinkedList<>();
        } else {
            try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
                try {
                    ordinazioni = (LinkedList<Ordinazione>)ois.readObject();
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }catch(IOException ex) {
                System.out.println(ex.getMessage());
            }            
        }
    }

    public String getFilename() {
        return filename;
    }
    
    public boolean isEmpty() {
        return ordinazioni.isEmpty();
    }
    
    public synchronized void aggiungiOrdinazione(Ordinazione ordinazione) {
        ordinazioni.add(ordinazione);
        this.notifyAll();
    }
    
    public synchronized Ordinazione consegnaOrdinazione() {
        while(isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        this.notifyAll();
        return ordinazioni.pollFirst();
    }
    
    public synchronized void salvaOrdinazioni() {
        while(isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(ordinazioni);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        notifyAll();
    }
}
