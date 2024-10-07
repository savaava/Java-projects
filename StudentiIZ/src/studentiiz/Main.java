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
        
        Persona s = new Studente();
        //s = (Studente)s;
        
        if(s instanceof Studente){
            Studente s3 = (Studente) s;
            System.out.println(s3.getVotoMedio());
        }
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
    }
}
