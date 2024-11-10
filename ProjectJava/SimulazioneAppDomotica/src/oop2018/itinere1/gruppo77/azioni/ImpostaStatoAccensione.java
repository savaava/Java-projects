package oop2018.itinere1.gruppo77.azioni;

import oop2018.itinere1.gruppo77.dispositivi.Attuatore;

public class ImpostaStatoAccensione implements Azione {
    Attuatore attuatore;
    private boolean setOn;
    
    public ImpostaStatoAccensione(Attuatore attuatore, boolean setOn){
        this.attuatore=attuatore;
        this.setOn=setOn;
    }
    
            
    @Override
    public void esegui() throws Exception{
        if(setOn)
            attuatore.accendi();
        else
            attuatore.spegni();
    }
    
    @Override
    public String toString(){
        if(setOn)
            return "Tipo azione: Accendi - "+attuatore;
        return "Tipo azione: Spegni - "+attuatore;
    }
}
