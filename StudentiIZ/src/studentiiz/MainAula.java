package studentiiz;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainAula {
    public static void main(String[] args) /*throws AulaPienaException (altra sol)*/{
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "HABSD", "0612893", 29F);
        
        Aula a = new Aula("M",1);
        //Accessibile a = new Aula("M",1);
        /*questo ci obbliga al try catch perchè lo andiamo a definire nell'interfaccia*/
        
        
        try {
            /*catturare -> mi obblica a racchiudere l'invocazione di questo metodo in un blocco
            
            p3 esiste solo nel try*/
            Persona p3 = a.esce();
            a.entra(p);            
            /*nel catch c'è ex perchè ho messo throws*/
        } catch (AccessibileException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } 
        /*
        } catch (AulaPienaException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AulaVuotaException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        try {
            a.entra(s);
        } catch (AccessibileException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } finally { /*il try catch può continuare con questo*/
            System.out.println("finally ");
        }

        /*
        nel finally forziamo le istruzioni di chiudere le connessioni coi server aperte nel try
        */
    }
}
