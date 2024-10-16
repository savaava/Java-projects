package it.unisa.diem.oop.persone;

import java.util.Comparator;

public class EtaComparator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        /*consente di stabilire una relazione tra i due parametri, persone */
//        return o1.getEta() - o2.getEta();
        /*essendo numeri interi non ci sono problemi
        ci potrebbero essere più livelli di confronto:*/
        if(o1.getEta() != o2.getEta())
            return o1.getEta() - o2.getEta();
        return o1.compareTo(o2);
        
        /*per un float si usa clasi wrapper: */
//        if(o1.getEta() != o2.getEta())
//            return Float.compare(o1.getEta(),o2.getEta() );
//        return o1.compareTo(o2);
    }    
}
