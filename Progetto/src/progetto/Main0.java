package progetto;
import lezioni.package1.*;
import lezioni.package1.package11.ClasseTre;

public class Main0 {
    public static void main(String[] args) {
        lezioni.package1.ClasseUno obj = new lezioni.package1.ClasseUno();  
        obj.stampaValore();
        
        ClasseUno obj1 = new ClasseUno(33);        
        ClasseDue obj2 = new ClasseDue("ciao mondo");        
        ClasseTre obj3 = new ClasseTre(0.99f);
        
        obj1.stampaValore();
        obj2.stampaStringa();
        obj3.stampaValore();
    }    
}
