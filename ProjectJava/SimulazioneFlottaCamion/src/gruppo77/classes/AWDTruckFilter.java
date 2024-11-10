package gruppo77.classes;

import gruppo77.interfaces.TruckFilter;
import static gruppo77.enums.DriveWheelType.*;

public class AWDTruckFilter implements TruckFilter {
    @Override
    public boolean checkTruck(Truck t){
        return (t.getDw()==AWD_4X4 || t.getDw()==AWD_6X6);
    }
}
