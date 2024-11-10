package contest1.test;

import contest1.gruppo77.enums.TeacherType;
import contest1.gruppo77.classes.Person;
import contest1.gruppo77.classes.Student;
import contest1.gruppo77.classes.Teacher;
import contest1.gruppo77.classes.SelectStudentFilter;
import contest1.gruppo77.classes.SelectYoungPersonFilter;
import contest1.gruppo77.classes.Department;
import java.util.List;

public class TestDepartment {
    public static void main(String[] args) {
        Department d = new Department();
        
        d.add(new Person("Matteo", "Baldi", 1991, 4, 1));
        d.add(new Person("Luca", "Rossi", 1994, 2, 15));
        d.add(new Student("Marco", "Verdi", "0612708762", 1995, 7, 11));
        d.add(new Student("Luigi", "Bianchi", "0612701732", 1996, 2, 14));
        d.add(new Teacher("Gennaro", "Percannella", TeacherType.ASSOCIATE_PROFESSOR, 1973, 5, 18));
        d.add(new Teacher("Mario", "Vento", TeacherType.FULL_PROFESSOR, 1960, 1, 5));
        System.out.println(d);
        d.sort();
        System.out.println("Ordino gli elementi-----------------------------------");
        System.out.println(d);
        
        System.out.println("Ottengo nuovo dipartimento con persone nate dopo l'1/1/1995");
        List<Person> d1 = d.filter(new SelectYoungPersonFilter(1995,1,1));
        System.out.println(d1);
        
        System.out.println("Ottengo nuovo dipartimento contenente solo gli studenti");
        List<Person> d2 = d.filter(new SelectStudentFilter());
        System.out.println(d2);
    }    
}
