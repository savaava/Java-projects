package gestioneristorante;

public class BackupAutomatico implements Runnable{
    private Comande comande;
    
    public BackupAutomatico(Comande comande){
        this.comande = comande;
    }
    
    @Override
    public void run(){
        while(! Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(20*1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            
            comande.salvaOrdinazioni();
            System.out.println("BACKUP EFFETTUATO");
        }
    }
}
