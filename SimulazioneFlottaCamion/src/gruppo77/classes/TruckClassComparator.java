package gruppo77.classes;

import gruppo77.classes.Truck;

import java.util.Comparator;

public class TruckClassComparator implements Comparator<Truck> {
    /* secondo criterio di ordinamento, diverso da compareTo ridefinito in Truck che implementa Comparable */
    
    @Override
    public int compare(Truck o1, Truck o2){ /* doppio livello di ordinamento: */
        
        if(o1.getTruckClass() != o2.getTruckClass()) /* se hanno classi di peso differenti allora si ordina rispetto a questo */
            return (o1.getTruckClass() - o2.getTruckClass());
        
        /* se hanno stessa classe peso -> primo criterio di ordinamento: quello di compareTo (lessicografico di chassisID) */
        return o1.compareTo(o2);
    }
}
