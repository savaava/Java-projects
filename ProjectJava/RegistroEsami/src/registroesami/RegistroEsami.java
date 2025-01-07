package registroesami;

import java.util.Iterator;
import java.util.TreeMap;

public class RegistroEsami extends TreeMap<String, Libretto> 
        implements Iterable<Libretto>, java.io.Serializable {
    
    public RegistroEsami(){
        super(new ComparatoreMatricolaDecrescente());
    }
    
    public boolean aggiungiEsame(String matricola, Esame esame){
        Libretto l = get(matricola);
        if(l == null) return false;        
        return l.add(esame);
    }
    
    public Iterator<Libretto> iterator(){
        return values().iterator();
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("RegistroEsami\n");
        values().forEach(libretto -> strb.append(libretto).append("\n"));
        return strb.toString();
    }
}
