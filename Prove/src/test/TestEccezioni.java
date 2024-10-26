package test;

import classi.ClasseFiglia1;
import classi.ClasseMadre;
import classi.ClasseProva;
import classi.ComplexNumber;
import exceptions.AccessibileUnoException;
import classi.Coordinate2D;
import exceptions.NonControllataException;
import exceptions.NumeriComplessiException;

public class TestEccezioni {
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
        
        System.out.println("\n\n");
        
        
        ComplexNumber z = new ComplexNumber(2.1,3.5);
        System.out.println(z);
        try{
            z.add(new ComplexNumber());
            System.out.println("\nNumeriComplessiException non catturata"+z);
        }catch(NumeriComplessiException ex){
            System.out.println(ex.getMessage());
        }        
        try{
            z.add(new ComplexNumber(-2.5,5));
            System.out.println("\nNumeriComplessiException non catturata"+z);
        }catch(NumeriComplessiException ex){
            System.out.println("\n"+ex.getMessage());
        }
//        try{
//            z.add(new ComplexNumber(-2.5,5));
//            System.out.println("\nNumeriComplessiException non catturata"+z);
//        }finally{
//            System.out.println("finallyyyyy");
//        }
        
        
        System.out.println("\n\n");
        
        try{
        ClasseProva.metodoProveEccezione(5);
        ClasseProva.metodoProveEccezione(-5);
        }catch(NonControllataException | ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
        try{
        ClasseProva.metodoProveEccezione(-5);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
        }
        try{
        ClasseProva.metodoProveEccezione(-5);
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("\n\n");
        
        /* eccezioni non controllate con il blocco */
        try{
            int out = 5/0;
        }catch(ArithmeticException ex){
            System.out.print("unchecked ex: ");
            System.out.println(ex.getMessage());
        }
        
        try{
            String strVett[] = new String[3];
            strVett[0] = "ciao0";
            strVett[1] = "ciao1";
            strVett[2] = "ciao2";
            String out = strVett[5];
        }catch(IndexOutOfBoundsException ex){
            System.out.print("unchecked ex: ");
            System.out.println(ex.getMessage());
        }finally{
            System.out.println("finallyyy -> andiamo avanti");
        }
        
        try{
            ClasseMadre o = null;
            //o.metodo1();
        }finally{
            System.out.println("finallyyy -> andiamo avanti");
        }
        
        System.out.println("\n\n");
        
        
        /* eccezioni non controllate normali */
        //double div = 5/0; /* causa java.lang.ArithmeticException: / by zero */
        
        Integer interi[] = new Integer[2];
        interi[0] = 333;
        interi[1] = 333;
        //interi[2] = 333; /* causa java.lang.ArrayIndexOutOfBoundsException: 2 */
        
        String str = null;
        //System.out.println(str.length()); /* causa java.lang.NullPointerException */
        
        //ClasseMadre o = new ClasseMadre();
        //ClasseFiglia1 oCastato = o;
    }
}
