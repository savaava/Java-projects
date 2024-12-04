package it.unisa.diem.oop.test;

import it.unisa.diem.oop.developed.EQReport;
import it.unisa.diem.oop.developed.MagnitudeComparator;

/**
 *
 * @author lucagreco
 */
public class EQRTest {
    public static void main(String[] args) {        
        EQReport eq0 = EQReport.readFromTextFile("query.txt");
        //System.out.println("***** Report dei terremoti dal file letto senza Scanner *****\n"+eq0);
        
        EQReport eq = EQReport.readFromTextFile("query.txt");        
        //System.out.println("***** Report dei terremoti dal file letto con Scanner *****\n"+eq);
        
        eq.sort(new MagnitudeComparator());        
        EQReport.printToTextFile(eq, "sorted.txt");
    }    
}

