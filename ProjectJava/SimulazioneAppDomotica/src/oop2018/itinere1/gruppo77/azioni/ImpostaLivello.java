package oop2018.itinere1.gruppo77.azioni;

import oop2018.itinere1.gruppo77.dispositivi.AttuatoreRegolabile;

public class ImpostaLivello implements Azione {
    private AttuatoreRegolabile ar;
    private double livelloDaImpostare;
    
    public ImpostaLivello(AttuatoreRegolabile ar, double livelloDaImpostare){
        this.ar=ar;
        this.livelloDaImpostare=livelloDaImpostare;
    }
    
    
    @Override
    public void esegui() throws Exception{
        ar.setLivello(livelloDaImpostare);
    }
    
    @Override
    public String toString(){
        return "Tipo azione: ";
    }
}
