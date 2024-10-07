package studentiiz;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.Accessibile;
import it.unisa.diem.oop.spazi.Aula;


public class MainAula {
    public static void main(String[] args) {
        /*
    07/10
    POLIMORFISMO
    il singolo oggetto quando viene istanziato può avere diverse forme,
    diverse implementazioni poli morifco
    
    Interfaccia
    A differenza della classe astratta, si possono definire solo metodi
    astratti e non ha uno stato -> quindi non ha un costruttore
    Un'interfaccia è un modo per sopperire al problema che non si può fare 
    ereditarietà multipla, perchè in java non si possono ereditare più di 1 classe
    
    
    */
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "HABSD", "0612893", -29F);
        
        Accessibile a = new Aula("M",4); //è lo stesso meccanismo dell'upcast
        /*
        L'interfaccia definisce un tipo di dato: tipo interfaccia
        Gli assegnamo Aula 
        Eredito i metodi di Object perchè sto usando comunque una classe Aula 
        Interfaccia mostra SOLO I SERVIZI DISPONIBILI PER L'IMPLEMENTAZIONE
        Interfacca -> classe astratta -> classe concreta
        
        Ad esempio per lo stack l'interfaccia è: pop push top isfull isempty
        Interfaccia list: poi linked list, ... ma i meteodi saranno sempre quelli 
        dell'interfaccia
        
        QUindi accessibile è un tipo
        
        
        Una classe può implementare più interfacce e non c'è conflitto come ereditarietà multipla:
        perchè siccome è astratto poi si farà l'override di quel metodo abstract che è unico
        */
        
        
        //Aula a = new Aula("M",4);
        a.entra(p); 
        a.entra(s); //upcast immediato
        
        System.out.println(a);
        System.out.println(p);
        
        
        
        /*
        condizioni anomale che possono portare a interruzioni: 
        accedere a uno spazio, dividere per 0, downcast exception
        ECCEZIONI
        Qual è la causa delle eccezioni
        1) la causa di anomalia è fuori, dipende da un'inidisponibilità esterna
        risora indisponibile, non è sotto il nostro controllo
        2) accedere ad un e non inizializzato delll array, significa che dipende
        da un'impedizia del programmatore
        
        Da queste due tipologie si determina la gestione di java per gli errori
        ossia eccezioni
        tipologie eccezioni controllate -> java scoraggia -> indurrano lo sviluppatore
        a porre rimedio: dei blocchi di codice che mi consentiranno di rimediare
        tipologie eccezioni non controllate -> arrestare il programma runtime senza
        richiedere allo sviluppatore di porre rimedio 
        classe Exception
        */
        
    }
}
