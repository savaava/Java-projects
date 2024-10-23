package prove;

import classi.ClasseFiglia1;
import classi.ClasseMadre;
import interfacce.InterfacciaMadre;

public class MainGenerico {
    public static void main(String[] args) {
        
        float x = 5F;
        x *= (float)Math.PI;
        System.out.println(x+"\n");
        
        InterfacciaMadre o1 = new ClasseMadre();
        o1.metodo1(); /* metodo1 ereditato dall'interfaccia */
        InterfacciaMadre.metodo2(); /* metodo2 */
        //o1.metodo2(); /* ERRORE */

        ClasseMadre o2 = new ClasseMadre();
        o2.metodoStaticoClasse(); /* metodo statico della classe */
        ClasseMadre.metodoStaticoClasse(); /* metodo statico della classe */
        ClasseFiglia1.metodoStaticoClasse();
    }
}
