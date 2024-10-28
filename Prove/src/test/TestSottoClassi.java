package test;

import classi.ClasseMadre;
import classi.ClasseFiglia1;
import classi.ClasseFiglia1Figlia;
import classi.ClasseFiglia2;

public class TestSottoClassi {
    public static void main(String[] args) {
        
        ClasseMadre madre = new ClasseMadre();
        
        ClasseFiglia1 figlio1 = new ClasseFiglia1();
        System.out.println("ClasseMadre -> ClasseFiglia1 -> ClasseFiglia1Figlia\nClasseMadre -> ClasseFiglia2\n");
        System.out.println("madre istanza di ClasseFiglia1: "+(madre instanceof ClasseFiglia1)); /* false */
        System.out.println("figlio1 istanza di ClasseMadre: "+(figlio1 instanceof ClasseMadre)); /* true */
        //System.out.println((figlio1.getClass() == ClasseMadre.class));                /* false */
        System.out.println((figlio1.getClass() == ClasseFiglia1.class));              /* true */
        System.out.println((figlio1.getClass() == ClasseFiglia1Figlia.class)+"\n\n"); /* false */
        
        ClasseFiglia2 figlio2;
        //System.out.println(figlio2 instanceof ClasseMadre);            /* ERRORE, not initialized */
        //System.out.println(figlio2.getClass() == ClasseFiglia2.class); /* ERRORE, not initialized */
        
        figlio2 = null;
        System.out.println(figlio2 instanceof ClasseMadre);              /* false, per instanceof null -> false */
        //System.out.println(figlio2.getClass() == ClasseFiglia2.class); /* ERRORE, NullPointerException */
        
        figlio2 = new ClasseFiglia2();
        System.out.println(figlio2 instanceof ClasseMadre);              /* true */
        System.out.println(figlio2.getClass() == ClasseFiglia2.class);   /* true */              
    }
}
