package gruppo77.interfaces;

import gruppo77.classes.TruckFleet;
import gruppo77.classes.Truck;

import java.util.Comparator;

public interface Filterable {
    TruckFleet filter(TruckFilter f, Comparator<Truck> c);
}
