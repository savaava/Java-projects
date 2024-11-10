/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest1.test;

import contest1.gruppo77.enums.TeacherType;
import contest1.gruppo77.classes.SelectStudentFilter;
import contest1.gruppo77.classes.Person;
import contest1.gruppo77.classes.Student;
import contest1.gruppo77.classes.Teacher;
/**
 *
 * @author solon
 */
public class TestSelectStudentFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SelectStudentFilter filter = new SelectStudentFilter();
        Person p; 
                
        //Test oggetto Person
        p = new Person("Matteo", "Baldi", 1998, 4, 1);
        System.out.println(p);
        if(!filter.checkPerson(p))
            System.out.print(" non ");
        System.out.println(" e' uno Student");

        
        //Test oggetto Student
        p = new Student("Luca", "Rossi", "0612708762", 1995, 7, 11);
        System.out.println(p);
        if(!filter.checkPerson(p))
            System.out.print(" non ");
        System.out.println(" e' uno Student");

            
        //Test oggetto Teacher
        p = new Teacher("Gennaro", "Percannella", TeacherType.ASSOCIATE_PROFESSOR, 1973, 5, 18);
        System.out.println(p);
        if(!filter.checkPerson(p))
            System.out.print(" non ");
        System.out.println(" e' uno Student");
    }
    
}
