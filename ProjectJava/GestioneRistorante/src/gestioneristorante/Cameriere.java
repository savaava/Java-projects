package gestioneristorante;

import java.util.Random;

public class Cameriere implements Runnable{
    private final String nome;
    private final Comande comande;

    public Cameriere(String nome, Comande comande) {
        this.nome = nome;
        this.comande = comande;
    }
    
    @Override
    public void run(){
        Random r1 = new Random(15000);
        Random r2 = new Random(15000);
        Random r3 = new Random(15000);
        
        while(! Thread.currentThread().isInterrupted()) {
            int tavoloNum = r1.nextInt(5)+1;
            int quantita = r2.nextInt(4)+1;
            int delay = r3.nextInt(6)+5;
                    
            try {
                Thread.sleep(delay*1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            
            Menu m = new Menu();
            Ordinazione ord = new Ordinazione(m.getPiatto(),tavoloNum,quantita);
            comande.aggiungiOrdinazione(ord);
            System.out.println("Ordinazione presa da "+nome+": "+ord);
        }
    }
}
