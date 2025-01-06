package it.unisa.diem.oop.threadgestioneristorante;

public class Cuoco implements Runnable {
    private final Comande comande;
    
    public Cuoco(Comande comande){
        this.comande = comande;
    }
    
    @Override
    public void run() {        
        while(! Thread.currentThread().isInterrupted()){
            int delay = (int)Math.round(5*Math.random()+5);
            try{Thread.sleep(1000*delay);}
            catch(InterruptedException ex){ex.printStackTrace();}
            
            Ordinazione ordinazione = comande.consegnaOrdinazione();
            System.out.println("Piatto pronto: "+ordinazione);
        }
    }
}
