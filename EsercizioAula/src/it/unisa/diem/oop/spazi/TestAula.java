package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.*;

public class TestAula {
    public static void main(String[] args) {
        Aula a = new Aula(4);
        
        //System.out.println(a.getInfoAula());
        
        a.entra(new Studente("Andrea", "Savastano", "SVSNDR04B128Q", "0612707904", 29F));
        a.entra(new Studente("Alessandroz", "Monte", "bho", "061270 qualcosa", 17.99F));
        a.entra(new Studente("Annamaria", "Scermino", "bhooo", "061270 qualcosa", 17.99F));
        
        System.out.println(a.getInfoAula());
        
        a.entra(new Studente());
        
        System.out.println(a.getInfoAula());
        
        /* proviamo gli altri metodi: */
        //System.out.println(a.aulaPiena());
        //System.out.println(a.aulaVuota());
        //a.entra(new Studente());
        //a.esce();
        
        //System.out.println(a.getInfoAula());
    }
}
