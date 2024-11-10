package it.unisa.diem.oop.developed.group77;

import java.time.Period;
import java.util.Comparator;

public class DeviceReleaseDateComparator implements Comparator<Device> {
    @Override
    public int compare(Device o1, Device o2){
        Period period = o1.getReleaseDate().until(o2.getReleaseDate());
        
        /* quando i dispositivi hanno la stessa data di rilascio */
        if(period.getYears()==0 && period.getMonths()==0 && period.getDays()==0){
            return o1.compareTo(o2); /* compareTo di Device quindi di String */
        }
        
        /* quando i dispositivi NON hanno la stessa data di rilascio */
        return o1.getReleaseDate().compareTo(o2.getReleaseDate()); /* compareTo di LocalDate */
    }
}
