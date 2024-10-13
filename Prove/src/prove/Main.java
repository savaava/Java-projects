package prove;
import java.util.logging.Level;
import java.util.logging.Logger;
import exceptions.AccessibileDueException;
import exceptions.AccessibileUnoException;
import newpackage.Coordinate2D;

public class Main {
    public static void main(String[] args) {
        /*String str = "Aa 77";
	char c;
	for(int i=0;  i<str.length();  i++) {
            c = str.charAt(i);
            System.out.println("\n'"+c+"':");
            System.out.println("isLetter -> "+Character.isLetter(c));
            System.out.println("isDigit -> "+Character.isDigit(c));
            System.out.println("isWhitespace -> "+Character.isWhitespace(c));
            System.out.println("isUpperCase -> "+Character.isUpperCase(c));
            System.out.println("NumericValue -> "+Character.getNumericValue(c));
	}
        
        System.out.println();
        
        String str2 = "0612707904";
        int n = Integer.parseInt(str2);
        System.out.println("parseInt -> "+n);
        Integer num = Integer.valueOf(str2);
        System.out.println("valueOf -> "+num);
        System.out.println("compare -> "+Integer.compare(8,3));
        
        System.out.println();
        
        float x = 5F;
        x = x*(float)Math.PI;
        System.out.println(x);
        */
        
        
        Coordinate2D coord1 = new Coordinate2D(2.5f,2.4f);
        try {
            System.out.println(coord1.DistanzaDalCentro());
            System.out.println("Tutto a posto coord1.DistanzaDalCentro() non ha sollevato l'eccezione controllata");
        } catch (AccessibileUnoException ex) {
            System.out.println(ex.getMessage());
        }
                
        Coordinate2D coord2 = new Coordinate2D();
        try {
            System.out.println(coord2.DistanzaDalCentro());
            System.out.println("Tutto a posto coord2.DistanzaDalCentro() non ha sollevato l'eccezione controllata");
        } catch (AccessibileUnoException ex) {
            System.out.println(ex.getMessage());
        }
        
        Coordinate2D coord3 = new Coordinate2D();
        try {
            coord3.DistanzaDalCentro();
        } catch (AccessibileUnoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}