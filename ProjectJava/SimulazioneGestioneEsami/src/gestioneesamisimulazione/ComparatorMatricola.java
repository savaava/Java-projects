package gestioneesamisimulazione;

import java.util.Comparator;

public class ComparatorMatricola implements Comparator<EsameSuperato>{
    @Override
    public int compare(EsameSuperato o1, EsameSuperato o2){
        return o1.getMatricolaStudente().compareTo(o2.getMatricolaStudente());
    }
}
