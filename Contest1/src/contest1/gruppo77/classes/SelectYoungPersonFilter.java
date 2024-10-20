package contest1.gruppo77.classes;
import contest1.gruppo77.interfaces.PersonFilter;
import java.time.LocalDate;

public class SelectYoungPersonFilter implements PersonFilter {
    private final LocalDate maxDate;
    
    public SelectYoungPersonFilter(int year, int month, int dayOfMonth) {
        this.maxDate = LocalDate.of(year, month, dayOfMonth);
    }
    
    @Override
    public boolean checkPerson(Person p) {
        return p.getBirthDate().isAfter(maxDate);
    }
}
