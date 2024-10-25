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
        
        
        
        /*
        aspetto teorico 10 - 12 minuti -> 8 domande 4 sezioni -> 
        1 modello OOP - fondamenti java, 2 ereditarietà 3 eccezioni, 4 collezioni
        per ogni sezione 2 domande: 1 con un piccolo frammento di codice e 1 teorica
        4 possibili risposte per ogni domanda (solo nelle simulazioni ci sono più risposte)
        simulazione -> 1 o più risposte esatte
        esame -> 1 sola risposta esatta
        
        parte pratica vpl activity 45 minuti
        
        H,I,M,E -> 55 minuti alla fine non è tanto 
        
        
        
        E' possibile usare il forEach anche per gli array:
        
        per definizione il forEach per gli array si scorre tutti i posti dell'array, attraversanzo
        tutte le posizioni andando a visitare potenzialmente un elemento non inizializzato, a differenza delle
        collezioni che invece il foreach si prende solo gli elementi esistenti
        */
        //String riciclabili[] = new Strin[5]; -> 2 posizioni non inizializzate ad esempio
        String riciclabili[] = {"vetro","carta","cotone"};


        /*
        Attributi inizializzati in linea, attributi statici. se non lo inizializziamo si imposta a 0/null
        inizializzatore statico = blocchetto{} con la parola static (simile al costruttore) e inizializza
        l'attributo, è l'equivalente del costruttore ma per lo spazio statico

        interfacce viste sono nella modalità iniziale -> rispettano quel contratto implicitamente public
        e astratti. da java 8 c'è un cambiamento: ci possono essere dei metodi di default e dei metodi statici
        ad esempio per Math ci possono essere dei metodi statici, non possono essere ereditate dalle 
        sottointerfacce le sottointerfacce ereditano tutti i metodi TRANNE I METODI STATICI */
        
        /*
        23/10
        2 concetti
        static import, codice per il calcolo numerico: dobbiamo scrivere un package che fa un uso massicio
        di espressioni matematiche 
        import static java.lang.Math.PI; perchè in questo modo non c'è bisogno di scrivere ogni volta Math.PI
        import static java.lang.Math.*;  cos(PI * theta);
        IMPORTO SOLO LE COSE STATICHE
        
        import static java.lang.System.*;
        out.println("HELLO FUNZIONAAA");
        
        
        
        tipi enumerativi Enum
        
        */
        
        
        /*
        25/10
        casting runtime 
        override 
        
        1) il blocco/inizializzatore static{} è un blocco di codice che viene chiamato solo una volta
        all'inizio quando viene chiamato un metodo della classe (quando si usa un metodo statico
        senza inizializzare un oggetto -> blocco static)
        (oppure quando viene istanziato il primo oggetto -> blocco statico) 
        solo la prima volta !
        poi c'è un blocco di inizializzazione non statico ????
        ???????? serve ad esempio per inizializzare una variabile statica = 0 per il conteggio
        risposta: static inizializer, static metod, ????? 
        
        2) risposta: vero è scorretto una classe non può essere statica, solo una classe annidata
        
        3) risposta: falso
        
        4) risposta: vero
        
        5) risposta: falso (set e get)
        
        6) risposta: true
        
        una classe astratta può estendere solo un'altra classe astratta
        
        1.0 NON E' UN OVERRIDE E' UN OVERLOADING perchè si distingue dal tipo in ingresso
        
        Un metodo che dichiara una clausola throws può essere invocato solo se si gestisce
        all’interno di un blocco try-catch. non è vero perchè si potrebbe mettere throws anche per unchecked
        
        123
        
        Override vale quando il tipo di ritorno è una sottoclasse 
        
        
        
        
        
        
        private final Set<Persona> elenco;
        va bene 
        */
        String str2 = 'c';
        String str = new String('c');
    }
}
