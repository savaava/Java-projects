package gestioneesamiio;

import java.util.Comparator;

public class ComparatoreMatricola implements Comparator<EsameSuperato>{
    @Override
    public int compare(EsameSuperato o1, EsameSuperato o2){
        return o1.getMatricolaStudente().compareToIgnoreCase(o2.getMatricolaStudente());
    }
}
