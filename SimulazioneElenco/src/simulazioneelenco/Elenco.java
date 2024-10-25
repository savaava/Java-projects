package simulazioneelenco;

import java.util.Set;
import java.util.HashSet;

public class Elenco {
    Set<Persona> e;
    
    public Elenco(){
        e = new HashSet<>();
    }

    public void aggiungi(Persona p) {
        e.add(p);
    }   

    @Override
    public String toString() {
        StringBuffer strb = new StringBuffer("L'elenco è formato da:\n");
        for(Persona pi : this.e){
            strb.append("***\n").append(pi).append("\n");
        }
        return strb.toString();
    }
}