package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.Persona;

public interface Accessibile {
    /*IL VANTAGGIO E' PROPRIO QUELLO DI OBBLIGARE IL PROGRAMMATORE A FARE IL CONTROLLO
    E A GESTIRE L'ECCEZIONE, quando viene invocato il metodo entra -> devo per forza
    mettere il blocco try catch*/
    
    /*
    Se non metto throws ... c'è un errore perchè se istanzio Accessibile ho un upcast e
    dovrei vedere che Accessibile a.entra può avere un'eccezzione che è scritta nella 
    classe concreta, ma se non è stato definito qui allora 
    Le sottoclassi non possono quindi aggiungere eccezioni, ma solo rimuoverle
    */
    void entra(Persona p) throws AccessibileException;
    Persona esce() throws AccessibileException;    
    /*se un metodo nell'interfaccia può lanciare un accessibileExc. allora la classe
    che implementa l'eccezione può lanciare AccessibileException oppure una sua sottoclasse
    ma non una classe che è sopra */
}
