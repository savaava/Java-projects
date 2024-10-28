package test;

import classi.ClasseFiglia1;
import classi.ClasseMadre;
import interfacce.InterfacciaMadre;
import interfacce.InterfacciaFiglia;

public class TestMetodiEreditati {
    public static void main(String[] args) {
        System.out.println("\n---------------------------------------------\n");
        
        InterfacciaMadre.metodo2();   /* metodo2 statico di InterfacciaMadre */
        InterfacciaFiglia.metodo2();  /* metodo2 statico di InterfacciaFiglia */
        ClasseMadre.metodo2();        /* metodo2 statico di ClasseMadre */

        ClasseMadre madre = new ClasseMadre();
        madre.metodo2();              /* metodo2 statico di ClasseMadre */
        
        System.out.println("\n---------------------------------------------\n");        
        ClasseMadre.metodo2();   /* metodo2 statico di ClasseMadre */
        ClasseFiglia1.metodo2(); /* metodo2 statico di ClasseMadre */

        ClasseMadre figlio = new ClasseFiglia1();
        figlio.metodo2();        /* metodo2 statico di ClasseMadre */

        ClasseFiglia1 figlio2 = new ClasseFiglia1();
        figlio2.metodo2();       /* metodo2 statico di ClasseMadre */
        
        System.out.println("\n---------------------------------------------\n");
    }
}
