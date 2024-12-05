package gestioneristorante;

import java.util.Random;

public class Cuoco implements Runnable{
    private final Comande comande;
    
    public Cuoco(Comande comande) {
        this.comande = comande;
    }
    
    @Override
    public void run(){
        Random r = new Random(31);
        
        while(! Thread.currentThread().isInterrupted()){
            int delay = r.nextInt(6)+5;
            try {
                Thread.sleep(delay*1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            Ordinazione oCurr = comande.consegnaOrdinazione();
            System.out.println("Piatto pronto: "+oCurr);
        }
    }
}
