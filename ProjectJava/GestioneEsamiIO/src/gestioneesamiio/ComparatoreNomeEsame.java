package gestioneesamiio;

import java.util.Comparator;

public class ComparatoreNomeEsame implements Comparator<EsameSuperato>{
    @Override
    public int compare(EsameSuperato o1, EsameSuperato o2){
        return o1.getNomeEsame().compareToIgnoreCase(o2.getNomeEsame());
    }
}
