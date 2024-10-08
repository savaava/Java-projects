package studentiiz;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.*;


public class MainAula {
    public static void main(String[] args) {
        Persona p = new Persona("Mario", "Rossi", "MRS0001");
        Studente s = new Studente("Stefano", "Grigi", "HABSD", "0612893", -29F);
        
        Accessibile a = new Aula("M",4);
        
        a.entra(p); 
        a.entra(s); //upcast immediato
        
        System.out.println(a);
        System.out.println(p);        
    }
}
