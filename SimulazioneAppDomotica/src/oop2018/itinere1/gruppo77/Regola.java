package oop2018.itinere1.gruppo77;

import oop2018.itinere1.gruppo77.azioni.Azione;
import oop2018.itinere1.gruppo77.condizioni.Condizione;

public class Regola {
    private Condizione condizione;
    private Azione azione;
    
    public Regola(Condizione condizione, Azione azione){
        this.condizione=condizione;
        this.azione=azione;
    }
    
    public Condizione getCondizione(){
        return condizione;
    }
    public Azione getAzione(){
        return azione;
    }
    
    public boolean applica(){
        if(condizione.verifica()){
            try{
                azione.esegui();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
            return true;
        }                    
        return false;
    }
    
    @Override
    public String toString(){
        return "Informazioni regola - "+condizione+" - "+azione;
    }
}
