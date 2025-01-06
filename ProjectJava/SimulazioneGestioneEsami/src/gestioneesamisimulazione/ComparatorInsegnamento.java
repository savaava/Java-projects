package gestioneesamisimulazione;

import java.util.Comparator;

public class ComparatorInsegnamento implements Comparator<EsameSuperato>{
    @Override
    public int compare(EsameSuperato o1, EsameSuperato o2){
        return o1.getNomeInsegnamento().compareTo(o2.getNomeInsegnamento());
    }
}
