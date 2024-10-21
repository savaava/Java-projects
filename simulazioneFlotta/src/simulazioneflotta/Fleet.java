package simulazioneflotta;



import java.util.Set;
import java.util.HashSet;


public class Fleet {
    
   private final String name;
   private Set<Truck> flotta;

    public Fleet(String name) {
        this.name = name;
        flotta = new HashSet<Truck>();
    }
    
    public void add(Truck o) {
        this.flotta.add(o);
    }
    
    public Fleet filterFoodGrade() {
        Fleet flottaNuova = new Fleet(this.name);
        
        for(Truck ti : this.flotta){
            if(ti.getClass() == Tanker){
                ti = (Tanker)ti;
                if(ti.isFoodGrade())
                    flottaNuova.add(ti);
            }
            
            
        }
        
        return flottaNuova;
    }

    @Override
    public String toString() {
       StringBuffer strb = new StringBuffer("myFleet contains: \n");
       for(Truck ti : this.flotta){
            strb.append(ti.toString()).append("\n");
        }
        return strb.toString();
    }
}



