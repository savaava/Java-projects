package gruppo77.classes;

import gruppo77.enums.DriveWheelType;
import gruppo77.enums.TruckType;

public class Dumper extends Truck { /* camion con cassone ribaltabile */
    private final boolean sideDumpCapable;
    
    public Dumper(boolean sideDumpCapable, String chassisID, DriveWheelType dw,
            int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, tt, truckClass);
        
        this.sideDumpCapable = sideDumpCapable;
    }
    
    public Dumper(String chassisID, DriveWheelType dw,
            int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, tt, truckClass);
        
        this.sideDumpCapable = false;
    }
    
    public Dumper(String chassisID, DriveWheelType dw,
            int year, int month, int dayOfMonth, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, TruckType.STANDARD, truckClass);
        
        this.sideDumpCapable = false;
    }
    
    public boolean isSideDumpCapable(){
        return sideDumpCapable;
    }
    
    
    @Override
    public boolean validateTruck(){
        return (getTruckClass()>=1 &&
                getTruckClass()<=8 && 
                getChassisID().matches("^D[A-Z]{2}\\d{4}$")); /* solo lettere maiuscole */
    }
    
    @Override
    public String toString(){
        if(sideDumpCapable)
            return "Dump Truck \n"+super.toString()+"\nSide Dump= available";
        return "Dump Truck \n"+super.toString();
    }
}
