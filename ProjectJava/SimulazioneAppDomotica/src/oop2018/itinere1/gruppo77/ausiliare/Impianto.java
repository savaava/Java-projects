package oop2018.itinere1.gruppo77.ausiliare;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import oop2018.itinere1.gruppo77.dispositivi.Dispositivo;

public class Impianto {
    private final String nome;
    private final List<Regola> regole;
    private final Map<Integer,Dispositivo> dispositivi;
    
    public Impianto(String nome){
        this.nome=nome;
        regole = new ArrayList<>();
        dispositivi = new HashMap<>();
    }
    
    public Dispositivo add(Dispositivo d){
        return dispositivi.put(d.getId(),d);
    }
    
    public void add(Regola r){
        r.applica();
        regole.add(r);
    }
    
    public Dispositivo getDispositivo(int id){
        return dispositivi.get(id);
    }
    
    public void applicaRegole(){
        regole.forEach(ri -> ri.applica());
    }
    
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("\n=====================\nInformazioni impianto\n=====================\n");
        strb.append("\nNome: ").append(nome).append("\n\n");
        
        strb.append("---- Elenco dispositivi ----\n");
        dispositivi.values().forEach(di -> strb.append(di).append("\n"));
        
        strb.append("\n\n---- Elenco regole ----\n");
        int i=0;
        for(Regola ri : this.regole){
            i++;
            strb.append(i).append(" ").append(ri).append("\n");
        }
        
        return strb.toString();
    }
}
