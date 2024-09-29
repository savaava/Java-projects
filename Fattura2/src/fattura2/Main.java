/*
Obiettivo: Implementare una classe Fattura per gestire la vendita di prodotti.

Dettagli della classe:

	1.	La classe Fattura deve avere:
	•	Una descrizione di tipo stringa.
	•	Un numero identificativo di tipo intero.
	•	Un array di oggetti Prodotto.
	2.	Funzionalità richieste:
	•	Aggiungere uno alla volta i prodotti all’array all’interno della fattura.
	•	Al termine dell’inserimento dei prodotti, deve essere stampata una 
rappresentazione della fattura, comprensiva di descrizione, numero identificativo e l’elenco dei prodotti inseriti.
*/

package fattura2;

public class Main {
    public static void main(String[] args) {
        int numProd = 4;
        
        Fattura f = new Fattura("ciao non so se funzionerà questa fattura", 769, numProd);
        
        /*
        Prodotto p2 = new Prodotto();
        Prodotto p3 = new Prodotto();
        Prodotto p4 = new Prodotto();
        Prodotto p5 = new Prodotto();        */
        
        f.inserimentoProdotto(new Prodotto());
        f.inserimentoProdotto(new Prodotto());
        
        f.stampaFattura();
        
        /*
        System.out.println(p3);
        System.out.println(p4);
        non sono inizializzati e posso stampare */
        
        f.inserimentoProdotto(new Prodotto());
        f.inserimentoProdotto(new Prodotto());
        //f.inserimentoProdotto(new Prodotto());
        
        
        f.stampaFattura();
    }    
}
