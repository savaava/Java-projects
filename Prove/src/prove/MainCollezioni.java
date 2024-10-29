package prove;

import classi.ClasseMadre;
import classi.ClasseFiglia1;
import classi.ComplexNumber;
import interfacce.InterfacciaMadre;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainCollezioni {
    public static void main(String[] args) {
        
        List<Integer> interi = new LinkedList<>();
        interi.add(44);
        interi.add(213);
        interi.add(78);
        interi.add(9);
        interi.add(11);
        System.out.println("\n\ninteri: "+interi+"\nSIZE: "+interi.size()+"\nlast element: "+interi.get(interi.size()-1));
        
        List<Integer> interi2 = interi.subList(0,interi.size());
        System.out.println("\n\ninteri2: "+interi2+"\nSIZE: "+interi2.size()+"\nlast element: "+interi2.get(interi2.size()-1));
        
        //List listaGenerica = new ArrayList<>();
        //List listaGenerica = new ArrayList();         /* va bene */
        List<Object> listaGenerica = new ArrayList<>(); /* va bene */
        listaGenerica.add(43);
        listaGenerica.add(0.99f);
        listaGenerica.add(new ComplexNumber(6.1, 5.95));
        listaGenerica.add(new ClasseMadre());
        listaGenerica.add("\nsono una stringa");        
        String vettS[] = new String[3];
        listaGenerica.add(vettS);
        
        System.out.println("\n\n"+listaGenerica);
        
        //List<ClasseMadre> listaProva = new ArrayList<ClasseFiglia1>();
        
        System.out.println("\n---------------------------------------------\n");
        
        System.out.println("interi: "+interi);
        Iterator<Integer> interiIt = interi.iterator();
        while(interiIt.hasNext()){
            Integer interoTmp = interiIt.next();
            System.out.println(interoTmp);
            if(interoTmp.equals(78))
                interiIt.remove();
            System.out.println("interi: "+interi);
        }
        
        System.out.println("\n---------------------------------------------\n");
        
        List<Integer> interi3 = new ArrayList<Integer>();
        interi3.add(5);
        interi3.add(-2);
        interi3.add(112);
        //interi3.add("proviamo");
        
        System.out.println("\n---------------------------------------------\n");
        
        
    }
}