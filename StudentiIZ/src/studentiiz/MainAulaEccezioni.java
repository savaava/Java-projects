package studentiiz;
import it.unisa.diem.oop.spazi.exceptions.AccessibileException;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.*;
import it.unisa.diem.oop.spazi.exceptions.AulaPienaException;
import it.unisa.diem.oop.spazi.exceptions.AulaVuotaException;
import it.unisa.diem.oop.spazi.exceptions.VotoNonConsentitoException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainAulaEccezioni {
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
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("finallyyyyy");
        }
        
        try {
            a.entra(s);
            a.esce();
        } catch (AulaPienaException ex) {
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println("Eccezione generica");
        }
        
//        try {
//            a.entra(s);
//        }catch(Exception ex){
//            System.out.println("Eccezione generica");
//        }catch(AulaPienaException ex){
//            System.out.println(ex.getMessage());
//        } 
        
        try {
            a.entra(s);
            a.esce();
        }catch(AulaPienaException ex){
            System.out.println("Eccezione generica");
        }catch(AccessibileException ex){
            System.out.println(ex.getMessage());
        }
    }
}
