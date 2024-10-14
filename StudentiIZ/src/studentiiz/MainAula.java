package studentiiz;
import it.unisa.diem.oop.spazi.exceptions.AccessibileException;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.*;
import it.unisa.diem.oop.spazi.exceptions.AulaPienaException;
import it.unisa.diem.oop.spazi.exceptions.AulaVuotaException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainAula {
    public static void main(String[] args) /*throws AulaPienaException (altra sol)*/{
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "HABSD", "0612893", 29F);
        
        Aula a = new Aula("M",4);
        //Accessibile a = new Aula("M",1);
        /*questo ci obbliga al try catch perchè lo andiamo a definire nell'interfaccia*/
        
        
        try {
            Persona p3 = a.esce();
            a.entra(p);            
            /*nel catch c'è ex perchè ho messo throws*/
        } catch (AulaPienaException | AulaVuotaException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            a.entra(s);
        } catch (AulaPienaException ex) {
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*nel finally forziamo le istruzioni di chiudere le connessioni coi server aperte nel try*/
            System.out.println("finallyyyyy");
        }        
    }
}
