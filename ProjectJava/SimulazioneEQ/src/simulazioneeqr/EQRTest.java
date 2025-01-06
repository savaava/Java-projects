package simulazioneeqr;

public class EQRTest {
    public static void main(String[] args) {        
        EQReport eq = EQReport.readFromTextFile("query");        
        System.out.println(eq);
        
        eq.sort(new MagnitudeComparator());        
        EQReport.printToTextFile(eq, "sortedComparator.csv");
        
        eq.sort();
        EQReport.printToTextFile(eq, "sortedNaturally.csv");
    }    
}
