package test;

import classi.ClasseMadre;
import classi.ClasseFiglia1;
//import classi.ClasseFiglia1Figlia;
import classi.ClasseFiglia2;

public class TestSottoClassi {
    public static void main(String[] args) {
        
        ClasseMadre madre = new ClasseMadre();
        ClasseFiglia1 figlio1 = new ClasseFiglia1();
        ClasseFiglia2 figlio2;

        System.out.println("ClasseMadre -> ClasseFiglia1 -> ClasseFiglia1Figlia\nClasseMadre -> ClasseFiglia2\n");
        System.out.println("madre istanza di ClasseFiglia1: "+(madre instanceof ClasseFiglia1)); /* false */
        System.out.println("figlio1 istanza di ClasseMadre: "+(figlio1 instanceof ClasseMadre)+"\n"); /* true */
        
        //System.out.println(figlio2 instanceof ClasseMadre); /* ERRORE */
        figlio2 = null;
        System.out.println(figlio2 instanceof ClasseMadre); /* false */
        figlio2 = new ClasseFiglia2();
        System.out.println(figlio2 instanceof ClasseMadre); /* true */
    }
}
