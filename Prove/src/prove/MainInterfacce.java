package prove;

import classi.ClasseFiglia1;
import classi.ClasseMadre;
import interfacce.InterfacciaFiglia;
import interfacce.InterfacciaMadre;

public class MainInterfacce {
    public static void main(String[] args) {
        InterfacciaMadre o1 = new ClasseMadre();
        o1.metodo1(); /* metodo1 ereditato dall'interfaccia */
        InterfacciaMadre.metodo2(); /* metodo2 */
        //o1.metodo2(); /* ERRORE */

        System.out.println();
        
        ClasseMadre o2 = new ClasseMadre();
        o2.metodo2(); /* metodo statico della classe */
        ClasseMadre.metodo2(); /* metodo statico della classe */
        ClasseFiglia1.metodo2();
        
        System.out.println();
        
        InterfacciaMadre o = new ClasseMadre();
        o.metodo3();
        InterfacciaFiglia o3 = new ClasseMadre();
        o3.metodo3();
    }
}
