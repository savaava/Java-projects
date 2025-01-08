package provaio;

import java.util.Comparator;

public class ComparatoreGis implements Comparator<String>, java.io.Serializable {
    @Override
    public int compare(String o1, String o2){
        return o2.compareToIgnoreCase(o1);
    }
}
