package simulazioneflotta;

import java.time.LocalDate;


public class Truck {
    
  private final String chassisID;
  private final LocalDate registrationDate;

    public Truck(String chassisID, LocalDate registrationDate) {
        this.chassisID = chassisID;
        this.registrationDate = registrationDate;
    }

    public String getChassisID() {
       return this.chassisID;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }
    

    @Override
    public int hashCode() {      
        return this.chassisID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if(obj == null)
        return false;
       if(this == obj)
        return true;
       if(!(obj instanceof Truck))
        return false;
    
       Truck tmp = (Truck)obj;
       return this.chassisID.equals(tmp.chassisID);
    }

    @Override
    public String toString() {
        return "\nTruck{chassisID="+this.chassisID+", registrationDate="+this.registrationDate+"}";
    }
    
    
    
}

