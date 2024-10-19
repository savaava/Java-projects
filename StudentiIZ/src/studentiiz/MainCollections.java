package studentiiz;
import it.unisa.diem.oop.persone.EtaComparator;
import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainCollections {
    public static void main(String[] args) {
        Persona p = new Persona("Mario20", "Rossi", "MRS0001");
        Persona p1 = new Persona("Mario25", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano30", "Grigi", "MRS0001", "0612893", 29F);
        
        boolean test;
        
        test = p.equals(p1);
        System.out.println(test);
        
        test = p.equals(s);
        System.out.println(test);
        
        Persona p2 = p1.clona();
        test = p1.equals(p2);
        System.out.println(test); 
        
        System.out.println("\n\n\n");
        
        /*
        Un oggetto che ci consente di attraversare la collezione e ci sono una serie di metodi da implementare
        convertire (come faccio a dire se due collezioni sono uguali)
        */
        
        List<Persona> persone = new ArrayList<Persona>();
        persone.add(p);
        persone.add(s);
        persone.add(p1);
        System.out.println(persone+"\n");
        
        for(Persona pm : persone){
            System.out.println(pm);
        }
        System.out.println();
        
        Iterator<Persona> piterator = persone.iterator();
        while(piterator.hasNext()){
            Persona pcurr = piterator.next();
            System.out.println(pcurr);
        }
        
        /*
        è buona norma stabilire il tipo di dato più gnerale possibile affinchè in presenza
        di un aggiornamento futuro non causa troppi problemi
        */
        
        System.out.println("\n\n\n"+persone.get(1));
        
        List<Persona> persone1 = new LinkedList<Persona>();
        
        System.out.println("SET");
        Set<Persona> persone2 = new HashSet<Persona>();
        
        persone2.add(p);
        persone2.add(s);
        persone2.add(p1);
        System.out.println(persone2);
        
        System.out.println(persone2.contains(s));
        
        
        
        
        System.out.println("\n\n\nTREE---------------------------------------------------");
        
        Set<String> parole = new TreeSet<>();        
        parole.add("ciao");
        parole.add("benvenuti");
        parole.add("attenzione");
        System.out.println(parole);
        
        
        
        Set<Persona> persone3;
        persone3 = new TreeSet<>(new EtaComparator());
        p.setEta(20);
        p1.setEta(25);        
        s.setEta(30);
        persone3.add(s);
        persone3.add(p);
        persone3.add(p1);
        System.out.println("\n\n"+persone3);
        /*run time va a cercare l'implementazione del metodo compareTo e non trovandola errore*/
        
        /*Comparator interfaccia generica che mi consente di definiire una classe che la implementa
        e quindi un oggetto comparatore (queste interfacce usate sort per le liste) */
        
        
        
        
        Set<Integer> numeri = new TreeSet<>();
        numeri.add(5);
        numeri.add(4);
        numeri.add(5);
        numeri.add(5);
        numeri.add(0);
        numeri.add(-6);
        numeri.add(2);
        System.out.println("\n\n"+numeri);
        
        
        p = new Persona("Mario20", "Rossi", "MRS0001");
        p1 = new Persona("Mario25", "Rossi", "M220022");
        s = new Studente("Stefano30", "Grigi", "M330033", "0612893", 29F);        
        Set<Persona> persone4 = new TreeSet<>(new EtaComparator());
        p.setEta(20);
        p1.setEta(25);
        s.setEta(30);
        persone4.add(s);
        persone4.add(p);
        persone4.add(p1);
        System.out.println("\n\n"+persone4);
    }
}
