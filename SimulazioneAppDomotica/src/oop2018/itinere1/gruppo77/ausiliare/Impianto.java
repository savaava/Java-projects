package oop2018.itinere1.gruppo77.ausiliare;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import oop2018.itinere1.gruppo77.dispositivi.Dispositivo;

public class Impianto {
    private final String nome;
    private final List<Regola> regole;
    private final Set<Dispositivo> dispositivi;
    
    public Impianto(String nome){
        this.nome=nome;
        regole = new ArrayList<>();
        dispositivi = new HashSet<>();
    }
    
    public Dispositivo add(Dispositivo d){        
        if(! dispositivi.contains(d)){
            dispositivi.add(d);
            return null;
        }
        
        Dispositivo dSostituito = null;
        for(Dispositivo di : dispositivi){
            if(di.equals(d))
                dSostituito = di;
        }
        dispositivi.add(d);
        return dSostituito;
    }
    
    public void add(Regola r){
        r.applica();
        regole.add(r);
    }
    
    public Dispositivo getDispositivo(int id){
        for(Dispositivo di : dispositivi){
            if(di.getId()==id)
                return di;
        }
        return null;
    }
    
    public void applicaRegole(){
        for(Regola ri : this.regole){
            ri.applica();
        }
    }
    
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("\n=====================\nInformazioni impianto\n=====================\n");
        strb.append("\nNome: ").append(nome).append("\n\n");
        
        strb.append("---- Elenco dispositivi ----\n");
        for(Dispositivo di : dispositivi){
            strb.append(di).append("\n");
        }
        
        strb.append("\n\n---- Elenco regole ----\n");
        int i=0;
        for(Regola ri : this.regole){
            i++;
            strb.append(i+" ").append(ri).append("\n");
        }
        
        return strb.toString();
    }
}
