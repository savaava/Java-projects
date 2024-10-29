package gruppo77.classes;

import gruppo77.enums.DriveWheelType;
import gruppo77.enums.TankType;
import gruppo77.enums.TruckType;

public class Tanker extends Truck { /* camion cisterna */
    private final TankType ttype;
    private final int capacity;
    
    public Tanker(TankType ttype, int capacity, String chassisID, DriveWheelType dw, 
            int year, int month, int dayOfMonth, TruckType tt, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, tt, truckClass);
        
        this.ttype = ttype;
        this.capacity = capacity;
    }
    
    public Tanker(TankType ttype, int capacity, String chassisID, DriveWheelType dw, 
            int year, int month, int dayOfMonth, int truckClass){
        super(chassisID, dw, year, month, dayOfMonth, TruckType.STANDARD, truckClass);
        
        this.ttype = ttype;
        this.capacity = capacity;
    }
    
    public TankType getTtype(){
        return ttype;
    }
    public int getCapacity(){
        return capacity;
    }
    
    
    @Override
    public boolean validateTruck(){
        return (getTruckClass()>=1 &&
                getTruckClass()<=8 && 
                getChassisID().matches("^T[A-Z]{3}\\d{3}$")); /* solo lettere maiuscole */
    }
    
    @Override
    public String toString(){
        return "Tank Truck \nTank Type:"+ttype+"\nTank capacity:"+capacity+"\n"+super.toString();
    }
}
