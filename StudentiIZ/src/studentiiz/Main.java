package studentiiz;
import it.unisa.diem.oop.persone.*;

public class Main {
    public static void main(String[] args) {
        /*
        degli studenti voglio tenere traccia di alcune cose (matricola, )
        dei docenti anche (matricola, corso nome di insegnamento)
        i tecnici
        
        le varie classi ripetono gli attributi come matricola
        quindi per una progettazione efficiente posso immaginare che al di sopra di queste
        entità ce ne sia una che contiene questi elementi comuni -> persona
        che contiene nome cognome codice fiscale perchè sono comuni a tutte le persone
        però già la matricola non ce l'hanno le persone, quindin 
        posso iummaginare già un altro livello dove tutte le persone unisa hanno la matricola
        
        classe madre persona
        persona unisa -> figlia di persone
        docente studente tecnico -> figlie di persone unisa
        RELAZIONE TRA CLASSI: ereditarietà
        quindi persona studente ha TUTTI gli attributi o metodi
        di persona unisa ma ha anche il voto merdio, ...
        */
        Persona p2 = new Persona("savasio","sava","IFBUIBi43534");
        PersonaUnisa p = new PersonaUnisa("Mario","Rossi","IFBUIBSA","0612707904");
        System.out.println(p.getNome()+" "+p.getCognome()+" "+p.getMatricola());
    }    
}
