package prove;

import classi.ClasseProva;
import classi.OuterClass;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MainNested {    
    public static void main(String[] args) {
        /* come un metodo statico */
        OuterClass.StaticNestedClass.m();
        
        /* istanzio direttamente la classe statica */
        OuterClass.StaticNestedClass o = new OuterClass.StaticNestedClass();
        
        System.out.println("\n--------------------------------------------------\n");
        
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.m();
        
        OuterClass.InnerClass innerObj2 = new OuterClass().new InnerClass();
        
        //new OuterClass().new InnerClass().m();
        
        System.out.println("\n--------------------------------------------------\n");
        
        outerObj.metodo();
        
        System.out.println("\n--------------------------------------------------\n");
        
	List<String> c = new ArrayList<String>();
	c.add("Mario");
        c.add("Ernesto");
        c.add("Luca");
        c.add("Margherita");		
        
        
        c.sort(null); 
        /* ordina secondo la compareTo di String per Comparable<String> */	
        System.out.println(c);
        
        
        c.sort(new Comparator<String>() {
            @Override
	    public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });	
        /* per ordina in base alla lunghezza */
        System.out.println(c);     
        
        System.out.println("\n--------------------------------------------------\n");
        
        ClasseProva obj = new ClasseProva() {
            public int x = 3; /* disponibile solo nella classe anonima */
            
            @Override
            public void m(){
                System.out.println("m - classe anonima");
            }
        };
        obj.m();
    }
}
