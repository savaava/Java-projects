package classi;

import interfacce.InterfacciaFiglia;
import interfacce.InterfacciaMadre;

public class ClasseMadre implements InterfacciaMadre,InterfacciaFiglia {
    @Override
    public void metodo1(){
        System.out.println("metodo1 ereditato dall'interfaccia");
    }
      
    public static void metodo2(){
        System.out.println("metodo2 statico di ClasseMadre");
    }
    
//    @Override
//    public void metodo3(){
//        System.out.println("metodo3 default di InterfacciaMadre");
//    }
}
