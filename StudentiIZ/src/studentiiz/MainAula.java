package studentiiz;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainAula {
    public static void main(String[] args) /*throws AulaPienaException (altra sol)*/{
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "HABSD", "0612893", 29F);
        
        /*
        09/10
        gestione degli errori in java:
        classe Error non bisogna specializzarla
        
        nel caso in cui c'è errore nell'inout dobbiamo fare un blocco
        in cui controlliamo l'errore
        
        downcast è causa interna -> problemi di questo tipo vengono gestiti
        con eccezzioni non controllate RuntimeException
        
        tutte le classi che specializzano RuntimeException definiscono le eccezioni
        non controllare
        
        eccezioni controllate:
        per definizione estende Exception
        */
        
        Aula a = new Aula("M",1);
        //Accessibile a = new Aula("M",1);
        /*questo ci obbliga al try catch perchè lo andiamo a definire nell'interfaccia*/
        
        
        try {
            /*catturare -> mi obblica a racchiudere l'invocazione di questo metodo in un blocco
            */ 
            /*p3 esiste solo nel try*/
            Persona p3 = a.esce(); /*se esce solleva l'eccezione -> non viene eseguito
            quello che c'è dopo. ALl'interno del blocco non appena un metodo solleva
            l'eccezzione si passa al catch rispettivo direttamente*/
            a.entra(p);
            
            /*questo metodo POTREBBE lanciare l'eccezione -> si deve definire catch
            non viene raccomandato questo blocco perchè è meno leggibile e appesantiscono
            molto il codice.*/
            
            /*nel catch c'è ex perchè ho messo throws*/
        } catch (AccessibileException ex) { 
            /*perchè raccolgo tutte le possibili eccezioni con AccessibileExc oppure:
            catch (Exception ex) direttamente, raccogliendo con la superclasse di 
            tutti -> gestitìsco TUTTE le eccezioni della gerarchia*/
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } 
        /* oppure
        } catch (AulaPienaException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AulaVuotaException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        /*il blocco è costituito da queste due cose: */
        try { 
            /*va specificato il metodo che PUO' sollevare l'eccezione
            try = prova a invocare il metodo se non funziona vai in catch*/
            a.entra(s); //upcast immediato
        } catch (AulaPienaException ex) {            
            /*posso prendere delle contromisure: */
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
            /*a differenza del runtime non si arresta in modo anomalo */
        } finally {
            System.out.println("finally ");
        }
        
        System.out.println(a);
        System.out.println(p);
        
        /*il try catch può continuare con questo*/
        
    }
}
