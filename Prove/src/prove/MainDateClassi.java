package prove;
import java.time.LocalDate;
import java.time.Period;

public class MainDateClassi {
    public static void main(String[] args) {
        
        LocalDate data1 = LocalDate.of(2004, 2, 12);
        LocalDate data2 = data1;
        System.out.println("data1: "+data1+"\ndata2: "+data2);
        System.out.println("compareTo: "+data1.compareTo(data2));
        
        
        data2 = data2.plusDays(5);
        System.out.println("\ndata1: "+data1+"\ndata2: "+data2);
        System.out.println("compareTo: "+data1.compareTo(data2));
        System.out.println("isAfter: "+data1.isAfter(data2));
        System.out.println("period: "+data1.until(data2));
        System.out.println("period: "+data2.until(data1));
        
        
        Period period;
        data2 = data2.plusMonths(2).plusDays(13);
        System.out.println("\ndata1: "+data1+"\ndata2: "+data2);
        period = data1.until(data2);
        System.out.println("period: "+period+" -> Days: "+period.getDays());
        System.out.println("period: "+period+" -> Months: "+period.getMonths());        
        data2 = data2.plusDays(12);
        period = data1.until(data2);
        System.out.println("data1: "+data1+"\ndata2: "+data2);
        System.out.println("period: "+period+" -> Days: "+period.getDays());
        System.out.println("period: "+period+" -> Months: "+period.getMonths());
        
        
        data2 = data2.minusMonths(4).minusDays(9);
        System.out.println("\ndata1: "+data1+"\ndata2: "+data2);
        period = data1.until(data2);
        System.out.println("period: "+period+" -> Days: "+period.getDays());
        if(period.getDays()<-10 || period.getDays()>10 || period.getMonths()!=0 || period.getYears()!=0)
            System.out.println("Tra la data1 e data2 ci sono almeno 11 giorni di differenza");
        else
            System.out.println("Tra la data1 e data2 ci sono tra 0 e 10 giorni di differenza");
        
        
        data2 = data1.plusDays(8);
        System.out.println("\ndata1: "+data1+"\ndata2: "+data2);
        period = data1.until(data2);
        System.out.println("period: "+period+" -> Days: "+period.getDays());
        if(period.getDays()<-10 || period.getDays()>10 || period.getMonths()!=0 || period.getYears()!=0)
            System.out.println("Tra la data1 e data2 ci sono almeno 11 giorni di differenza");
        else
            System.out.println("Tra la data1 e data2 ci sono tra 0 e 10 giorni di differenza");
    }
}