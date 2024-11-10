package provacompilazione;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {        
        List<ClasseMadre> lista = new ArrayList<>();
        
        lista.add(new ClasseMadre(2000,2,28, 333));
        lista.add(new ClasseMadre(2000,2,28, 333));
        lista.add(new ClasseMadre(2103,2,28, 334));
        lista.add(new ClasseMadre(2001,2,28, 331));
        lista.add(new ClasseMadre(2088,2,28, 330));
        lista.add(new ClasseMadre(1999,2,28, 338));
        
        System.out.println("LISTA Senza Ordine degli elementi:");        
        System.out.println(lista);        
        
        System.out.println("\n-----------------------------------------------\n");        
        
        System.out.println("LISTA Ordine naturale degli elementi secondo Comparable (compareTo):");
        lista.sort(null);
        //Collections.sort(lista);
        System.out.println(lista);
        
        System.out.println("\n-----------------------------------------------\n");        
        
        System.out.println("LISTA Ordine degli elementi secondo il comparatore (compare):");
        lista.sort(new ComparatoreX());
        //Collections.sort(lista, new ComparatoreX());
        System.out.println(lista);
        
        
        
//        System.out.println("\n-----------------------------------------------\n");
//        
//        System.out.println("LISTA al contrario: ");
//        Collections.reverse(lista);
//        System.out.println(lista);
//        
//        System.out.println(Collections.frequency(lista, new ClasseMadre(2000,2,28, 333)));
//        
//        
//        System.out.println("\n-----------------------------------------------\n");
//        List<ClasseMadre> lista2 = new ArrayList<>();
//        System.out.println("lista2:");
//        lista2.add(new ClasseMadre(2004,2,28, 333));
//        lista2.add(new ClasseMadre(2004,11,30, 333));
//        System.out.println(lista2);
//        
//        System.out.println(Collections.disjoint(lista, lista2));
//        lista2.add(new ClasseMadre(2001,2,28, 339));
//        System.out.println(Collections.disjoint(lista, lista2));
    }
}
