package gestioneristorante;

import java.util.Random;

public class Cameriere implements Runnable{
    private final String nome;
    private final Comande comande;

    public Cameriere(String nome, Comande comande) {
        this.nome = nome;
        this.comande = comande;
    }

    public String getNome() {
        return nome;
    }

    public Comande getComande() {
        return comande;
    }
    
    @Override
    public void run(){
        Random r1 = new Random(33999);
        Random r2 = new Random(33999);
        Random r3 = new Random(33999);
        
        while(! Thread.currentThread().isInterrupted()) {
            int delay = r1.nextInt(6)+5;
            int tavoloNum = r2.nextInt(5)+1;
            int quantita = r3.nextInt(4)+1;
                    
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
