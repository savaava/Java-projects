package contest1.test;
import contest1.gruppo77.classes.Person;
        
public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person("Matteo", "Baldi", 1998, 4, 1);        
        System.out.println(p);
        Person p2 = new Person("Luca", "Rossi", 1994, 2, 15);
        System.out.println(p2);
        if(p.compareTo(p2)>0)
            System.out.println("La persona più anziana e': \n" + p);
        else if(p.compareTo(p2)<0)
            System.out.println("La persona più anziana e': \n" + p2);
        else
            System.out.println("La persone sono coetanee");
    }    
}
