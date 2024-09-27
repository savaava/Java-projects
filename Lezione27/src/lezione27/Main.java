package lezione27; //package
import it.unisa.diem.oop.gestionemagazzino.Fattura;
/*import it.unisa.diem.oop.gestionemagazzino.*; per importare tutto però
potrebbe non servire e quindi essere inefficiente (wildcard)*/

public class Main {
    public static void main(String[] args) {
        /*
        package realizza una forma di organizzazione logica per le nostre classi sia fisica, 
        infatti vengono create delle cartelle. organizzare i file sorgenti e anche quelli 
        compilati. Organizzare tutte le classi in un package:
        nomenclatura precisa: URL inverso o dns inverso -> per raccogliare le classe per un 
        determinato progetto: creiamo un package
        
        più specializzo il dominio più è specifico il package 
        2 problematiche:
        organizzare le classi
        definire un nome che non comporti ambiguità

        specificare la provienenza della classe attraverso il package
        l'ambiente crea una gerarchia di cartelle automaticamente
        package -> comporta creare sottocartelle 
        
        voglio spostare solo Fattura 
        */
        
        Fattura f = new Fattura();
        /*per farlo dovrei contrassegnare il costruttore con tutto il percorso
        però è molto pesante scrivere tutto -> faccio così: IMPORTO IL PACKAGE
        
        fine ultimo:
        organizzare meglio il codice per quelle 3 caratteristiche: veriicabilità, riuis...*/
        
        
        f.inserimentoProdotto(new Prodotto(788));
        f.inserimentoProdotto(new Prodotto(0.88f));
        
        f.stampaFattura();
        
        
        /*in assenza dei modificatori dei metodi o per i metodi, allora il metodo
        è accessibile solo dalle classi interni allo stesso package*/
    }    
}
