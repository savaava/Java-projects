package gruppo77.classes;

import gruppo77.interfaces.TruckFilter;
import gruppo77.classes.Truck;
import gruppo77.classes.Tanker;

public class BigTankerFilter implements TruckFilter {
    private final int minCapacity;
    
    public BigTankerFilter(int minCapacity){
        this.minCapacity = minCapacity;
    }
    
    @Override
    public boolean checkTruck(Truck t){
        if(t.getClass() != Tanker.class)
            return false;
        
        Tanker tankerT = (Tanker)t;
        return (tankerT.getCapacity() >= minCapacity);
    }
}
