package registroesami;

import java.util.Comparator;

public class ComparatoreMatricolaDecrescente implements Comparator<String>, java.io.Serializable {
    @Override
    public int compare(String s1, String s2){
        return s2.compareToIgnoreCase(s1);
    }
}
