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
        
        /*
        come faccio a replicare un oggetto -> posso fare un interfaccia "clonabile" che mi serve per
        duplicare
        */
        
        Persona p2 = p1.clona();
        test = p1.equals(p2);
        System.out.println(test); 
        
        /*
        Ora possiamo parlare di collezioni
        le interfacce definiscono DEI TIPI -> si parte dalla definiizone dei metodi utili e poi l'implementazione
        e poi algoritmi (collection framework)
        diagrammi delle classi, ma in questo caso sono interfacce
        Mo capiamo prima il diagramma a sinistra poi dopo l'intercorso quello a destra
        
        Collection E' un'interfaccia generica (collezione di elementi è un evoluzione di un array)
        collection è la radice della gerarchia e poi Set -> potrò mettere elementi distinti tra loro:
        se metto persone con lo stesso CF allora ne metto una sola 
        SortedSet è un Set che mantiene un ordine degli elementi
        
        la lista può avere duplicati -> c'è un ordine e posso sempre ottenere leggere togliere inserire usando
        un indice, 
        
        Queue implementa il comportamento conosciuto in quest'interfaccia troviamo i metodi tipici della coda
        
        Deque ha sia un comportamento stack sia coda (sia LIFO che FIFO)
        
        le Map 
        
        tutte le collezioni CONTENGONO I RIFERIMENTI 
        
        Iterabile è una collezione per definizione nel senso che può essere visitata: posso scorrere 
        tutti gli elementi della collezione: al capo della gerarchia c'è Iterabile
        
        Un oggetto che ci consente di attraversare la collezione e ci sono una serie di metodi da implementare
        convertire (come faccio a dire se due collezioni sono uguali)
        
        1 forEach
        2 
        3 (casi più avanzati)
        */
        
        /*forEach mi scorre tutti gli oggetti della collezione, per i Set non c'è l'indice quindi devo usare
        il forEach o l'iteratore
        iteratore -> metodo iterator 2 metodi fondamentali: boolean i.hasNext e poi 2 i.next*/
        
        /*due implementazioni di lista: array list e linked list
        1 array che viene ridimensionato all'occorrenza
        2 */
        
        /*parto dall'interfacci*/
        List<Persona> persone;
        /*implementazione ci sono molte implementazioni (ne vediamo 2)*/
        persone = new ArrayList<Persona>();
        persone.add(p);
        persone.add(s);
        persone.add(p1); /*comportamento tipico della lista -> mette i duplicatiS*/
        /*la toString è già implementata in formato leggibile*/
        System.out.println(persone+"\n");
        /*voglio attraversare la collezione: 3 modi (forEach, iteratore, e un altro)*/
        for(Persona pm : persone){ //forEach è la rappresentazione più compatta
            /*ricordiamo sempre che pm viene castato a Persona quando si becca lo studente e 
            poi quando invoca la toString viene presa l'ultima ridefinizione della classe più bassa
            gerarchicamente*/
            System.out.println(pm);
        }
        /*iteratore*/
        Iterator<Persona> ip = persone.iterator();
        /*i 3 metodi abbiamo: */
        while(ip.hasNext()){
            /*qui ho verificato che esiste !!*/
            Persona pi = ip.next();
            System.out.println(pi);
        }
        /*completato l'iteratore "scade" ho finito l'attraversamento e quinndi non ripartirebbe
        da 0 -> devo reimpostare ip a 0*/
        
        /*algoritmi*/
        
        /*
        è buona norma è stabilire il tipo di dato più gnerale possibile affinchè in presenza
        di un aggiornamento futuro non causa troppi problemi
        sottointerfacce che implementano comportamenti specifici: voglio mantenere un ordine
        uso una lista, quali sono i metodi che ci mette a disposizione lista -> prendere elementi
        tramite index
        */
        
        System.out.println("\n"+persone.get(1));
        
        /*
        Set non accetta duplicati a differenza di list
        se nell'implementazione della classe non ci sono specifiche possiamo essere più 
        generici possibili
        
        list nasconda la dimensione variabile -> se la dimensione viene superata viene riprodotto
        un nuovo array esteso ma questo è nascosto
        linkedlist 
        */
        
        List<Persona> persone1 = new LinkedList<Persona>();
        
        /*non ha senso concettualmente mettere LinkedList<...> persone2
        perchè nasconde alcuni metodi
        mi serve una lista o un set ? dopo aver scelto il comportamento scelgo l'implementazione
        uno è un array l'altro è una lista doppiamente linkata*/
        
        /*per definizione NON AMMETTE DUPLICATI -> gli elementi sono distinti
        come faccio a dire se un elemento è un doppione
        quindi dovrei scorrere tutta la struttura e confrontare il parametro -> è un'operazione
        inefficiente -> meccanismo che non mi fa scorrere: */
        
        System.out.println("SET");
        Set<Persona> persone2; 
        
        /*dobbiamo trovare l'implementazione dell'interfaccia 2 impl. (hash set, o tree set)
        hash -> conviene perchè prima di tutto devo confrontare solo i numeretti per vedere
        se sono uguali. il codice hash punta a una lista di locazione (oggetti diversi )
        hash code restituisce intero il nuemeretto quando aggiungo nel Set 
        è possibile che due elementi abbiano lo stesso hash code e quindi ci sarebbero due
        elementi nel bucket list quindi il secondo elemento arriva nel bucket list non vuoto
        e verifico con equals se è lo stesso -> se è un duplicato allora non lo metto*/
        
        persone2 = new HashSet<Persona>();
        
        /*useremo l'hash code di Object che si basa su equals di Object, è inefficiente
        ridefinire hash code in maniera COERENTE CON EQUALS in maniera che due elementi
        con lo stesso CF hanno lo stesso hash code, e due elementi con CF diversi potrebbero 
        avere stesso hashcode*/
        
        /*l'add implica eseguire hashcode e equals*/
        persone2.add(p);
        persone2.add(s);
        persone2.add(p1);
        System.out.println(persone2);
        
        /*rispetto a l'equals viene valutato se l'elemento che vogliamo aggiungere è uguale
        nello stesso bucket si hanno oggetti diversi, grazie 
        dobbiamo solo ridefinire hashCode sulla base dell'equals */
        
        System.out.println(persone2.contains(s));
        /*per vedere se ujn oggetto è presente nella collezione ! senza il for Each 
        e utilizza sempre equals che abbiamo ridefinito*/
        
        System.out.println("TREE");
        Set<String> parole;
        parole = new TreeSet<>();
        
        parole.add("ciao");
        parole.add("benvenuti");
        parole.add("attenzione");
        System.out.println(parole); /*c'è un criterio di ordinamento e per farlo viene implementata un'interfaccia
        Comparable<T> che include il metodo compareTo()*/
        
        Set<Persona> persone3;
        persone3 = new TreeSet<>(new EtaComparator());
        s.setEta(30);
        p.setEta(20);
        p1.setEta(25);
        
        /*gli alberi devono avere una relazione d'ordine, quindi dobbiamo far in modo che gli oggetti
        abbiamo una relazione d'ordine -> come faccio a dire che una persona viene prima di un'altra */
        persone3.add(s);
        persone3.add(p);
        persone3.add(p1);
        System.out.println(persone3); //errore (senza ridefinizione)-> Studente cannot be cast to java.lang.Comparable
        /*run time va a cercare l'implementazione del metodo compareTo e non trovandola errore*/
        
        /*Comparator interfaccia generica che mi consente di definiire una classe che la implementa
        e quindi un oggetto comparatore (queste interfacce usate sort per le liste) */
    }
}
