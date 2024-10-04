package studentiiz;
import it.unisa.diem.oop.persone.*;

public class Main {
    public static void main(String[] args) {        
        Studente s1 = new Studente("Andrea", "Savastano", "SVSNDR04B128Q", "0612707904", 29F);
        System.out.println("Nome: "+s1.getNome());
        System.out.println("Cognome: "+s1.getCognome());
        System.out.println("Codice Fiscale: "+s1.getCodiceFiscale());
        System.out.println("Matricola: "+s1.getMatricola());
        System.out.println("Voto medio: "+s1.getVotoMedio());
        System.out.println();
        
        Persona p = new Persona();
        Studente s0 = new Studente();
        System.out.println(p.toString());
        System.out.println(s0.toString());
        /*      
        relazione ereditarietà: "is"
        relazione composizione: "has"
        */
        
        //Persona p4 = new Persona();
        //Studente s4 = (Studente) p4;
        Persona s = new Studente();
        /*
        Vantaggio:
        Se fisso un array di persone posso far entrare qualsiasi persona in Aula
        però per usare i metodi di studente anche se ha il riferimento declassato a 
        persona, devo fare il downcast, MA PRIMA DEVO VERIFICARE CHE APPARTIENE
        EFFETTIVAMENTE A QUELLA CLASSE:
        Voglio accedere alla persona nell'aula che è uno studente
        */
        if(s instanceof Studente){
            Studente s3 = (Studente) s;
            System.out.println(s3.getVotoMedio());
        }
        /* oppure: */
        if(s.getClass() == Studente.class){
            Studente s3 = (Studente) s;
            System.out.println(s3.getVotoMedio());
        }
        
        Persona p1[] = new Persona[5];
        p1[0] = new Persona();
        p1[1] = new Persona();
        p1[2] = new Studente();
        p1[3] = new Studente();
        p1[4] = new Studente();
        
        for(int i=0;  i<p1.length;  i++)
            System.out.println("descrizione p["+i+"]: "+p1[i]);
        
        /*
        s.getClass() restituisce un oggetto classe che identifica la classe di s Studente
        è utile quando voglio confrontare due oggetti, anche se si può usare instanceof
        
        
        
        PersonaUnisa rappresenta unentità concreta ?? una persona che sia una personaUnisa che ha solo
        la matricola e non è niente, non ha senso ISTANZIARLA e costringiamo allo sviluppatore a non istanziarlo
        ed eventualmente ad istanziare un metodo.
        Quindi esistono delle classi che progettiamo solo con scopo utilitaristico
        ossia le CLASSI ASTRATTE CHE NON POSSONO ESSERE ISTANZIATE 
        PersonaUnisa p1 = new PersonaUnisa(); l'unica cosa che precludde NO!
        nel dominio applicativo NON ESISTE QUESTA CLASSE quindi è astratta, ma serve comunque per specializzare 
        studenti, docenti,...
        
        
        
        tipo wrapper per convertire i tipi primitivi in classi, come int -> integer
        il vantaggio è che avremo i vari metodi
        */               
    }    
}
