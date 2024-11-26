package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.io.IOException;

public class TestAnagrafica {
    public static void main(String[] args) throws IOException {
        /* 20_11 InOut
        BUONA PRATICA: chiudere alla fine lo stream con finally, con closeable
        */
        
        AnagraficaStudenti a = new AnagraficaStudenti("OOP");        
        a.aggiungi(new Studente("Mario","Rossi","MRS001","0612707651",28.5F));
        a.aggiungi(new Studente("Stefano","Rossi","STS001","0612707652",28.5F));
        a.aggiungi(new Studente("Mario","Bianchi","MBS001","0612707653",28.5F));        
        System.out.print("******Anagrafica su cui effettuare operazioni di I/O******\n"+a
                        +"**********************************************************\n");
        
        String nomefile = "anagrafica.bin";        
        a.salvaDOS(nomefile);
        AnagraficaStudenti letturaFileAnagrafica = AnagraficaStudenti.leggiDOS(nomefile);
        System.out.println("Anagrafica letta dal file "+nomefile+":\n"+letturaFileAnagrafica);
        
        nomefile = "anagrafica.ser"; /* sempre binario */
        a.salvaOBJ(nomefile);
        System.out.println("\nAnagrafica letta dal file "+nomefile+":\n"+AnagraficaStudenti.leggiOBJ(nomefile));
                       
        nomefile = "anagrafica.csv";
        a.salvaCSV(nomefile);
        System.out.println("\nAnagrafica letta dal file "+nomefile+":\n"+AnagraficaStudenti.leggiCSV(nomefile));
        System.out.println("\nAnagrafica letta tramite Scanner dal file "+nomefile+":\n"
                +AnagraficaStudenti.leggiCSVScan(nomefile));
    }
}
