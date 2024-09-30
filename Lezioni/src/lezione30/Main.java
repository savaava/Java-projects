package lezione30;
import it.unisa.diem.oop.gestionemagazzino.*;

public class Main {
    public static void main(String[] args) {
        Fattura f = new Fattura("ciao descrizione f", 2322, 5);
        
        Prodotto p1 = new Prodotto(0.88f);
        
        f.inserimentoProdotto(new Prodotto(788));
        f.inserimentoProdotto(p1);
        
        f.stampaFattura();
        
        f=null;
        /*
        f=null; 
        -> l'oggetto prodotto con 788 viene distrutto
        -> l'oggetto porodotto p1 non viene distrutto
        */
        
        /*
        relazioni tra classi
        diverse relazioni come la composizione e l'aggregazione
        riferiamoci agli attributi che sono delle classi e quindi
        prendiamo degli oggetti come riferimento
        una classe che contiene attributi di tipo Stringa allora noi
        stiamo implementando iuna relazione tra la classse e la classe Stringa
        composizione vs aggregazione
        
        1) aggreagzione
        è meno forte come relazione
        un oggetto aggregante può esistere anche se non appartiene all'oggetto aggregato
        Prodotto -> oggetto aggregante 
        Fattura -> oggetto aggregato -> contiene 
        il ciclo di vita dell'oggetto fattura è indipendente dagli oggetti prodotti
        la new viene fatta all'esterno da fattura, gestisce solo i riferimenti 
        la Fattura non crea il prodotto, bensì aggrega i prodotti come abbiamo fatto noi
        Infatti i riferimenti ai prodotti all'inizio sono TUTTI a null, fino a quando
        non viene chiamato f.inserimento
        IL PRODOTTO VIENE CREATO/ISTANZIATA FUORI DALLA FATTURA -> AGGREGAZIONE
        
        LA STRINGA VIENE CREATA/ISTANZIATA DENTRO ALLA FATTURA -> COMPOSIZIONE
        2)composizione
        Ad esempio per gli attributi di classe stringa, essendo le stirnghe oggetti, 
        allora quando instanzio un oggetto nella classe
        il prodotto è composto da stringa, data, ...
        è l'oggetto prodotto che crea l'oggetto di tipo stringa o di tipo data,
        mentre fattura non crea necessariamente un oggetto di tipo prodotto
        
        l'oggetto fattura non ha più riferimenti attivi (f=null per far morire il
        riferimento) dopo l'oggetto fattura naturalmente non ha più riferimento
        attivo, però visto che i prodotti sono stati passati come para
        metro il prodotto non viene distrutto
        in questo caso però: 
        f.inserimentoProdotto(new Prodotto(0.88f));  (questa è comunque un'aggregazione) 
        f=null; -> cancella anche l'oggetto prodotto perchè è come se fosse stato creato
        all'interno 
        l'oggetto prodotto viene annullato
        invece la new è stata fatta fuori non viene distrutto il prodotto insieme alla
        fattura
        Prodotto p1 = new Prodotto(...);  f.inserimentoProdotto(p1);
        f=null; -> cancella solo fattura ma non prodotti
        gli attributi persistono fino a quando viene distrutto l'oggetto:
        °se ho un aggregazione -> gli oggetti non si distruggono automaticamente perchè
        non dipendono dalla classe che è stata distrutta, la dipendenza è più
        lasca perchè gli oggetti aggregati sono istanziati FUORI dalla classe
        °se ho una composizione -> gli oggetti creati perchè compongono la classe, vengono 
        distrutti automaticamente perchè dipendono dalla classe che li ha generati, 
        infatti vengono creati DENTRO la classe        
        
        spesso in UML non si definiscono tutte le composizioni perchè queste relazioni
        danno un dettaglio normalmente non si scende a questo livello, perchè sennò ci 
        sarebbe un diagramma enorme
        
        
        
        */
    }    
}
