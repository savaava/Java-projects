package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.io.IOException;

public class TestAnagrafica {
    public static void main(String[] args) throws IOException {
        /* 20_11 InOut
        
        BUONA PRATICA: chiudere alla fine lo stream con finally, con closeable
        
        ObjectInputStream serialaizable che dice al compilatore
        */
        
        AnagraficaStudenti a = new AnagraficaStudenti("OOP");        
        a.aggiungi(new Studente("Mario","Rossi","MRS001","0612707651",28.5F));
        a.aggiungi(new Studente("Stefano","Rossi","STS001","0612707652",28.5F));
        a.aggiungi(new Studente("Mario","Bianchi","MBS001","0612707653",28.5F));        
        System.out.print(a);        
        
        a.salvaDOS("anagrafica.bin");
        
        System.out.println("");
        AnagraficaStudenti letturaFileAnagrafica = AnagraficaStudenti.leggiDOS("anagrafica.bin");
        System.out.println(letturaFileAnagrafica);
    }
}
