package interfacce;

import classi.ClasseMadre;

public interface InterfacciaMadre {
    void metodo1();
    static void metodo2(){
        System.out.println("metodo2 statico dall'interfaccia madre");
        ClasseMadre o = null;
        o.equals(o); 
        /* è la classe ClasseMadre che eredita i metodi di Object,
        le interfacce non possono ereditare classi, ma solo altre interfacce*/
    }
}
