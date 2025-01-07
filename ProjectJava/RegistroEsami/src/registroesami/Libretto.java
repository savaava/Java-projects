package registroesami;

import java.util.HashSet;

public class Libretto extends HashSet<Esame> implements java.io.Serializable {
    private final Studente studente;
    
    public Libretto(Studente s){ /* super() implicita */
        studente = new Studente(s.getNome(), s.getCognome(), s.getMatricola());
    }
    
    public Studente getStudente(){
        return studente;
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer(studente.toString());        
        forEach(esame -> strb.append("\n").append(esame));        
        return strb.toString();
    }
}
