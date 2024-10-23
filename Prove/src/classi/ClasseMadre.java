package classi;

import interfacce.InterfacciaMadre;

public class ClasseMadre implements InterfacciaMadre {
    @Override
    public void metodo1(){
        System.out.println("metodo1 ereditato dall'interfaccia");
    }
      
    public static void metodoStaticoClasse(){
        System.out.println("metodo statico della classe");
    }
}
