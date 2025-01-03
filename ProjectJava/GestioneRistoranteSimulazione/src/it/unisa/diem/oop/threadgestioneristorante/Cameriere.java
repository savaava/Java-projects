package it.unisa.diem.oop.threadgestioneristorante;

public class Cameriere implements Runnable{
    private final Comande comande;
    private final String nome;
    
    public Cameriere(String nome, Comande comande){
        this.comande = comande;
        this.nome = nome;
    }
    
    @Override
    public void run(){
        Menu m = new Menu();
        
        while(! Thread.currentThread().isInterrupted()){
            int delay = (int)Math.round(5*Math.random()+5);
            try{Thread.sleep(1000*delay);}
            catch(InterruptedException ex){ex.printStackTrace();}
            
            String piatto = m.getPiatto();
            int tavolo = (int)Math.round(4*Math.random()+1);
            int quantita = (int)Math.round(3*Math.random()+1); 
            Ordinazione ordinazione = new Ordinazione(piatto, tavolo, quantita);
            
            comande.aggiungiOrdinazione(ordinazione);
            System.out.println("Ordinazione presa da "+nome+": "+ordinazione);
        }
    }
}
