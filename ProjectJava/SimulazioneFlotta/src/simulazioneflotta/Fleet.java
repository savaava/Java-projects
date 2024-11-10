package simulazioneflotta;

import java.util.Set;
import java.util.HashSet;

public class Fleet {
    
   private final String name;
   private final Set<Truck> flotta;

    public Fleet(String name) {
        this.name = name;
        flotta = new HashSet<Truck>();
    }
    
    public void add(Truck o) {
        this.flotta.add(o);        
    }
    
    public Fleet filterFoodGrade() {
        Fleet flottaNuova = new Fleet(this.name);
        Tanker tmpTi;
        
        for(Truck ti : this.flotta){
            if(ti instanceof Tanker){ /* vero solo quando ti è Tanker quindi è corretto */
            //if(ti.getClass() == Tanker.class){ /* va bene lo stesso */
                tmpTi = (Tanker)ti;
                if(tmpTi.isFoodGrade())
                    flottaNuova.add(tmpTi);
            }           
        }        
        return flottaNuova;
    }

    @Override
    public String toString() {
        return this.flotta.toString();
    }
}



