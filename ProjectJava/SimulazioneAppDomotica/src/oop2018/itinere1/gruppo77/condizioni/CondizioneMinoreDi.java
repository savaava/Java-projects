package oop2018.itinere1.gruppo77.condizioni;

import oop2018.itinere1.gruppo77.dispositivi.Sensore;

public class CondizioneMinoreDi implements Condizione {
    private Sensore sensore;
    private final double valoreDiConfronto;
    
    public CondizioneMinoreDi(Sensore sensore, double valoreDiConfronto){
        this.sensore=sensore;
        this.valoreDiConfronto=valoreDiConfronto;
    }            
    
    
    @Override
    public boolean verifica(){
        return sensore.getValore()<valoreDiConfronto;
    }
    
    @Override
    public String toString(){
        return "Tipo condizione: Minore di "+valoreDiConfronto+" - attivata per: "+sensore;
    }
}
