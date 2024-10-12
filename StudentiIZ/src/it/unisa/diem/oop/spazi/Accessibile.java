package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.spazi.exceptions.AulaPienaException;
import it.unisa.diem.oop.spazi.exceptions.AulaVuotaException;
import it.unisa.diem.oop.persone.Persona;

public interface Accessibile {
    /*
    Se non metto throws ... c'è un errore perchè se istanzio Accessibile ho un upcast e
    dovrei vedere che Accessibile a.entra può avere un'eccezzione che è scritta nella 
    classe concreta, ma se non è stato definito qui allora
    */
    void entra(Persona p) throws AulaPienaException;
    Persona esce() throws AulaVuotaException;
}
