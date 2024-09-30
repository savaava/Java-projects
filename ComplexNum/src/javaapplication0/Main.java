package javaapplication0;

public class Main {
    public static void main(String[] args) {      
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        ComplexNumber z1 = new ComplexNumber(3.33,5.1);
        System.out.println("z1: ");
        z1.stampaComplexNumberCartesiana();
        z1.stampaComplexNumberPolare();
        
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        ComplexNumber z2 = new ComplexNumber();
        System.out.println("z2: ");
        z2.stampaComplexNumberCartesiana();
        z2.stampaComplexNumberPolare();
        
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        
        z1.setParteReale(-12.1);
        z1.setParteImmaginaria(9.5);
        
        if(z1 instanceof ComplexNumber){
            System.out.println("\nz1 appartiene alla classe ComplexNumber");
        }
        
        System.out.println("\nInizializzazione tramite metodi setter: ");
        z1.stampaComplexNumberCartesiana();
        z1.stampaComplexNumberPolare();
    }    
}
