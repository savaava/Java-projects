/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest1.test;

import contest1.gruppo77.enums.TeacherType;
import contest1.gruppo77.classes.Teacher;
/**
 *
 * @author solon
 */
public class TestTeacher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Teacher p = new Teacher("Gennaro", "Percannella", TeacherType.ASSOCIATE_PROFESSOR, 1973, 5, 18);
        System.out.println(p);
        Teacher p2 = new Teacher("Mario", "Vento", TeacherType.FULL_PROFESSOR, 1960, 1, 5);
        System.out.println(p2);
        if(p.compareTo(p2)>0)
            System.out.println("La persona più anziana e': \n" + p);
        else if(p.compareTo(p2)<0)
            System.out.println("La persona più anziana e': \n" + p2);
        else
            System.out.println("La persone sono coetanee");
        
    }
    
}
