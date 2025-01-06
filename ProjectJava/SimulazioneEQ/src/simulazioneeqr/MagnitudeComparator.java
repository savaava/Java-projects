package simulazioneeqr;

import java.util.Comparator;

public class MagnitudeComparator implements Comparator<EQEvent> {
    @Override
    public int compare(EQEvent o1, EQEvent o2){
        return Float.compare(o1.getMag(), o2.getMag());
    }
}
