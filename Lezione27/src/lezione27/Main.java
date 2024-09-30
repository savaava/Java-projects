package lezione27;
import it.unisa.diem.oop.gestionemagazzino.Fattura;
/*import it.unisa.diem.oop.gestionemagazzino.*; */

public class Main {
    public static void main(String[] args) {        
        Fattura f = new Fattura("ciao descrizione f", 2322, 5);
        
        f.inserimentoProdotto(new Prodotto(788));
        f.inserimentoProdotto(new Prodotto(0.88f));
        
        f.stampaFattura();
    }    
}
