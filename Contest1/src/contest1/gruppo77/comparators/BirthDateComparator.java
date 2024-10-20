package contest1.gruppo77.comparators;

import contest1.gruppo77.classes.Person;
import java.util.Comparator;

public class BirthDateComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2){
        return o2.compareTo(o1);
    }
}
