/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest1.test;
import contest1.gruppo77.classes.SelectYoungPersonFilter;
import contest1.gruppo77.classes.Person;
import contest1.gruppo77.classes.Student;
/**
 *
 * @author solon
 */
public class TestSelectYoungPersonFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SelectYoungPersonFilter filter = new SelectYoungPersonFilter(1995,1,1);
        Person p; 
                
        // Test persona nata dopo l'1/1/1995
        p = new Person("Matteo", "Baldi", 1998, 4, 1);
        System.out.println(p);
        if(!filter.checkPerson(p))
            System.out.print(" non ");
        System.out.println(" e' una Young Person");

        
        // Test persona nata prima l'1/1/1995
        p = new Student("Luca", "Rossi", "0612708762", 1993, 7, 11);
        System.out.println(p);
        if(!filter.checkPerson(p))
            System.out.print(" non ");
        System.out.println(" e' una Young Person");
    }
    
}
