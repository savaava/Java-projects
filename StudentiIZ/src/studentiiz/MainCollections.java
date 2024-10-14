package studentiiz;

import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainCollections {
    public static void main(String[] args) {
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Persona p1 = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "MRS0001", "0612893", 29F);
        
        /* 14_10
        Collezioni 
        
        coll che non ammettono tutti i dati, e quindi devo confrontare gli oggetti
        con instanceof
        
        come faccio a vedere se due oggetti sono uguali ? Non mi conviene confrontare
        i riferimenti, perchè possono avere semplicmente riferimenti diversi
        
        metodo equals da Object per confrontare 2 oggetti
        usarlo significa mettere un oggetto Object che è quanto più generico possibile
        
        Noi ereditiamo un'implementazione da Object come toString e possiamo ridefinirla
        ctrl+equals
        riflessivo -> x=b -> b=x
        consistente -> invocazioni multiple generano stesso risultato
        ingresso a null -> sempre FALSE
        SI DEVONO RISPETTARE TUTTE LE DIRETtIVE
        confronta i riferimenti SE EREDITIAMO L'IMPLEMENTAZIONE ORIGINALE, QUINDI
        */
        
        boolean test1;
        
        test1 = p.equals(p1);
        System.out.println(test1);
        
        /*la proprietà simmetrica: se diamo allo studente lo stesso codice fiscale a s restituisce true 
        perchè non fanno parte di classe uguali, quindi if(this.getClass() != obj.getClass()) return false;
        Collezioni non ammettono duplicati -> io faccio entrare p ed s che hanno lo stesso codice fiscale 
        e in realtà non sono uguali, come faccio a mettere in discussione la proprietà simmetrica ?*/
        
        test1 = p.equals(s);
        System.out.println(test1);
        
        /*
        come faccio a replicare un oggetto -> posso fare un interfaccia "clonabile" che mi serve per
        duplicare
        */
        
        Persona p2 = p1.clona();
        test1 = p1.equals(p2);
        System.out.println(test1); 
        
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
    }
}
