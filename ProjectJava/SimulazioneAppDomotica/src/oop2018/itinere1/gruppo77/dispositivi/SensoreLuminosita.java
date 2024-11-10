package oop2018.itinere1.gruppo77.dispositivi;

public class SensoreLuminosita extends Sensore {
    public SensoreLuminosita(int id){
        super(id);
    }

    @Override
    public String toString(){
        return super.toString()+" - Tipo: Sensore di luminosità";
    }    
}
