package gruppo77.classes;

import gruppo77.enums.DriveWheelType;
import gruppo77.enums.TruckType;

public class BoxTruck extends Truck { /* camion furgone */
    private final boolean lutonBody;
    
    public BoxTruck(boolean lutonBody, String chassisID, DriveWheelType dw,
            int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, tt, truckClass);
        
        this.lutonBody = lutonBody;
    }
    
    public BoxTruck(String chassisID, DriveWheelType dw,
            int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, tt, truckClass);
        
        this.lutonBody = false;
    }
    
    public boolean hasLutonBody(){
        return lutonBody;
    }
    
    
    @Override
    public boolean validateTruck(){
        return (getTruckClass()>=1 &&
                getTruckClass()<=8 && 
                getChassisID().matches("^B[A-Z]{3}\\d{3}$")); /* solo lettere maiuscole */
    }
    
    @Override
    public String toString(){
        if(lutonBody)
            return "BoxTruck \n"+super.toString()+"\nwith Luton Body";
        return "BoxTruck \n"+super.toString();
    }
}
