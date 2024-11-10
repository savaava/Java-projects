package oop2018.itinere1.gruppo77.dispositivi;

//import oop2018.itinere1.gruppoXX.dispositivi.Dispositivo;

public abstract class Attuatore extends Dispositivo{    
    public Attuatore(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return super.toString() + " Categoria: Attuatore";
    }    
}
