package oop2017.contest1.gruppo77;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Aeroporto {
    private final List<Aeromobile> l;
    private final CodeChecker checker;
    
    public Aeroporto(CodeChecker checker){
        this.checker = checker;
        l = new ArrayList<>();
    }
    
    public boolean inserisci(Aeromobile a){
        if(checker == null){
            l.add(a);
            return true;
        }
        if(checker.check(a.getCodice())){
            l.add(a);
            return true;
        }           
        return false;
    }
    
    public Aeromobile cerca(String codice){
        for(Aeromobile ai : l){
            if(ai.getCodice().equals(codice))
                return ai;
        }
        return null;
    }    
    
    public Aeromobile rimuovi(String codice){
        Iterator<Aeromobile> ai = l.iterator();
        Aeromobile aTmp;
        
        while(ai.hasNext()){
            aTmp = ai.next();
            if(aTmp.getCodice().equals(codice)){
                ai.remove();
                return aTmp;
            }
        }
        
        return null;
    }
    
    public int elementi(){
        return l.size();
    }
    
    
     @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        for(Aeromobile ai : l){
            strb.append(ai).append("\n");
        }
        return strb.toString();
    }
}
