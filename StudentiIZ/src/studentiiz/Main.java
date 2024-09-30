package studentiiz;
import it.unisa.diem.oop.persone.*;

public class Main {
    public static void main(String[] args) {
        Persona p0 = new Persona("savasio","sava","IFBUIBi43534");
        
        PersonaUnisa p1 = new PersonaUnisa();
        
        Studente s1 = new Studente("Andrea", "Savastano", "SVSNDR04B128Q", "0612707904", 29F);
        System.out.println("Nome: "+s1.getNome());
        System.out.println("Cognome: "+s1.getCognome());
        System.out.println("Codice Fiscale: "+s1.getCodiceFiscale());
        System.out.println("Matricola: "+s1.getMatricola());
        System.out.println("Voto medio: "+s1.getVotoMedio());
        
        
    }    
}
