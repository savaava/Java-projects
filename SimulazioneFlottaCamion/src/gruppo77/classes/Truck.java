package gruppo77.classes;

import java.time.LocalDate;

import gruppo77.enums.TruckType;
import gruppo77.enums.DriveWheelType;

public abstract class Truck implements Comparable<Truck> {
    private final String chassisID; /* due camion uguali stesso ID */
    private final LocalDate registrationDate;
    private final DriveWheelType dw;
    private final TruckType tt;
    private final int truckClass;
    
    public Truck(String chassisID, DriveWheelType dw, int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        this.chassisID = chassisID;
        this.dw = dw;
        this.registrationDate = LocalDate.of(year, month, dayOfMonth);
        this.tt = tt;
        this.truckClass = truckClass;
    }
    
    public String getChassisID(){
        return chassisID;
    }
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
    public DriveWheelType getDw(){
        return dw;
    }
    public TruckType getTt(){
        return tt;
    }
    public int getTruckClass(){
        return truckClass;
    }
    
    
    public abstract boolean validateTruck();    
    
    @Override
    public int hashCode(){
        return chassisID.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        
        Truck tObj = (Truck)obj;
        return tObj.chassisID.equals(chassisID);
    }
    
    @Override
    public final int compareTo(Truck o){
        return chassisID.compareToIgnoreCase(o.chassisID);
    }
    
    @Override
    public String toString(){
        if(validateTruck())
            return "chassis ID="+chassisID+"\ntruck type="+tt+"\ndrive-wheel = "+dw+"\nregistration Date="+registrationDate+"\ntruck Class="+truckClass+"\nvalidation = PASSED";
        return "chassis ID="+chassisID+"\ntruck type="+tt+"\ndrive-wheel = "+dw+"\nregistration Date="+registrationDate+"\ntruck Class="+truckClass+"\nvalidation = NOT PASSED";
    }
}
