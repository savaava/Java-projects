package contest1.gruppo77.classes;
import contest1.gruppo77.interfaces.PersonFilter;

public class SelectStudentFilter implements PersonFilter {
    @Override
    public boolean checkPerson(Person p){
        return p instanceof Student;
    }
}
