package oop2018.itinere1.gruppo77.dispositivi;

//import oop2018.itinere1.gruppoXX.dispositivi.Dispositivo;

public abstract class Sensore extends Dispositivo{    
    private double valore;

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }
    
    public Sensore(int id) {
        super(id);
    }
    
    @Override
    public String toString() {
        return super.toString() + " Categoria: Sensore" + " Lettura: " + valore;
    } 
}
