package it.unisa.diem.oop.threadgestioneristorante;

public class BackupAutomatico implements Runnable {
    private final Comande comande;
    
    public BackupAutomatico(Comande comande){
        this.comande = comande;
    }
    
    @Override
    public void run() {        
        while(! Thread.currentThread().isInterrupted()){
            try{Thread.sleep(1000*20);}
            catch(InterruptedException ex){ex.printStackTrace();}

            comande.salvaOrdinazioni();
            System.out.println("BACKUP EFFETTUATO");            
        }
    }
}
