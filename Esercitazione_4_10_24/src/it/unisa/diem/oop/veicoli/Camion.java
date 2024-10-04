package it.unisa.diem.oop.veicoli;

public class Camion extends Veicolo{
    private final int numeroAssi;
    
    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numeroAssi){
        super(numTelaio, modello, alimentazione, targa);
        this.numeroAssi = numeroAssi;
    }
    
    public int getNumeroAssi(){
        return this.numeroAssi;
    }
    
    @Override
    public boolean controllaTarga(){
        return super.getTarga().matches("[A-Z]{2}[0-9]{6}");
    }
    
    @Override
    public String toString(){
        return super.toString()+", Numero assi = "+this.numeroAssi;
    }
}
