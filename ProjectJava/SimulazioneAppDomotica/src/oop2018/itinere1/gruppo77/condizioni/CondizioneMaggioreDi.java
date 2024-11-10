package oop2018.itinere1.gruppo77.condizioni;

import oop2018.itinere1.gruppo77.dispositivi.Sensore;

public class CondizioneMaggioreDi implements Condizione {
    private Sensore sensore;
    private final double valoreDiConfronto;
    
    public CondizioneMaggioreDi(Sensore sensore, double valoreDiConfronto){
        this.sensore=sensore;
        this.valoreDiConfronto=valoreDiConfronto;
    }
    
    
    @Override
    public boolean verifica(){
        return sensore.getValore()>valoreDiConfronto;
    }
    
    @Override
    public String toString(){
        return "Tipo condizione: Maggiore di "+valoreDiConfronto+" - attivata per: "+sensore;
    }
}
