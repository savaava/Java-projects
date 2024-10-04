package inf_hiding;

public class Main {
    public static void main(String[] args) {
        Prodotto p1 = new Prodotto(55,"hellooo worldd",0.99f);
        Prodotto p2 = new Prodotto(66,"helloo",8.75f);
        p1 = p2; //stesso indirizzo, i due riferimenti puntano allo stesso oggetto
        //l'oggetto p1 verrà deallocato in seguito automaticamente perchè non è raggiungibile
        //quindi adesso p1 e p2 è come se fossero lo stesso oggetto in questo momento
        
        /*
        Prodotto p3;
        Prodotto p4 = new Prodotto(66,"helloo",8.75f);
        p3 = p4;
        */
        
        System.out.println("Inizializzate di default: ");        
        p1.printProdotto();
        
        p1.setCodiceProdotto(12398);
        p1.setDescrizioneProdotto("Penna_2.0");
        p1.setCostoProdotto(5.99f);

        System.out.println("\nInizializzate dall'utente: ");
        System.out.println(p1.getCodiceProdotto());
        System.out.println(p1.getdescrizioneProdotto());
        System.out.println(p1.getcostoProdotto());
        
    }    
}
