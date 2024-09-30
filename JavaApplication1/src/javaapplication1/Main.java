package javaapplication1;

public class Main {
    public static void main(String[] args) {
        System.out.println("conteggio curr: "+Prodotto.getConteggioProdotti());
        Prodotto p = new Prodotto(55);
        System.out.println("conteggio curr: "+Prodotto.getConteggioProdotti());
        Prodotto p1 = new Prodotto(0.99F);
        System.out.println("conteggio curr: "+Prodotto.getConteggioProdotti());
        Prodotto p2 = new Prodotto("pennarello");
        System.out.println("conteggio curr: "+Prodotto.getConteggioProdotti());
        Prodotto p3 = new Prodotto(66,"helloo",8.75F);        
        System.out.println("conteggio curr: "+Prodotto.getConteggioProdotti());
        
        //Prodotto.raddoppiaConteggioProdotti();
        
        System.out.println("\np: ");        
        p.printProdotto();
        System.out.println("\np1: ");        
        p1.printProdotto();
        System.out.println("\np2: ");        
        p2.printProdotto();
        System.out.println("\np3: ");        
        p3.printProdotto();
    }    
}
