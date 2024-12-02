package it.unisa.diem.oop.test;

import it.unisa.diem.oop.developed.EQReport;
import it.unisa.diem.oop.developed.MagnitudeComparator;

/**
 *
 * @author lucagreco
 */
public class EQRTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        EQReport eq = EQReport.readFromTextFile("query.txt");
        
        System.out.println(eq);
        
        eq.sort(new MagnitudeComparator());
        
        EQReport.printToTextFile(eq, "sorted.txt");
        
        
        // TODO code application logic heres
    }
    
}

