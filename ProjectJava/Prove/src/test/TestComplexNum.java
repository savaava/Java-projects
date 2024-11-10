package test;

import classi.ComplexNumber;
import exceptions.NumeriComplessiException;
import exceptions.ParteRealeNegativaException;
import exceptions.ParteImmaginariaNegativaException;

public class TestComplexNum {
    public static void main(String[] args) {
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        ComplexNumber z1 = new ComplexNumber(3.33,5.1);
        System.out.println("z1: "+z1);
        
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        ComplexNumber z2 = new ComplexNumber();
        System.out.println("z2: "+z2);
        
        System.out.println("------------------ conteggio numeri curr: "+ComplexNumber.getConteggioNumeri());
        
        
        try{
            z1.add(z2);
        }catch(NumeriComplessiException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            z1.add(new ComplexNumber(-9.1, 7.8));
        }catch(ParteRealeNegativaException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println("eccezione generica per i numeri complessi");
        }
        
//        try{
//            z1.add(new ComplexNumber(-9.1, 7.8));
//        }finally{
//            System.out.println("ciao");
//        }
        
        
        if(z1 instanceof ComplexNumber){
            System.out.println("\nz1 è un istanza di ComplexNumber");
        }
        if(z1.getClass() == ComplexNumber.class){
            System.out.println("\nz1 è un oggetto ComplexNumber");
        }
        if(z1.getClass() == z2.getClass()){
            System.out.println("\nz1 e z2 sono oggetti della stessa classe");
        }
    }
}
