package contest1.gruppo77.classes;
import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    
    public Person(String name, String surname, int year, int month, int dayOfMonth) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.of(year, month, dayOfMonth);
    } 
    
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public LocalDate getBirthDate() {
        return this.birthDate;
    }
    
    /* final perchè non voglio che il metodo venga ridefinito nelle classi derivate */
    @Override
    public final int compareTo(Person p) {
        if(this.birthDate.getYear() != p.birthDate.getYear())
            return p.birthDate.getYear() - this.birthDate.getYear();
        if(this.birthDate.getMonth() != p.birthDate.getMonth())
            return p.birthDate.getMonth().getValue() - this.birthDate.getMonth().getValue();
        return p.birthDate.getDayOfMonth() - this.birthDate.getDayOfMonth();
    }
    
    @Override
    public String toString() {
        return "\n\nName = "+this.name+"\nSurname = "+this.surname+"\nBirth date = "+this.birthDate.toString();
    }
}
