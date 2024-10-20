package prove;

import exceptions.AccessibileUnoException;
import classi.Coordinate2D;

public class MainEccezioni {
    public static void main(String[] args) {
            
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
        
        System.out.println(coord1);
        System.out.println(coord2);
        System.out.println(coord3);
        System.out.println(coord2.equals(coord3));
    }
}
