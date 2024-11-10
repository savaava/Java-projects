package it.unisa.diem.oop.veicoli;

public class Moto extends Veicolo{
    private final boolean guidaLibera;
    
    public Moto(String numTelaio, String modello, String alimentazione, String targa, boolean guidaLibera){
        super(numTelaio, modello, alimentazione, targa);
        this.guidaLibera = guidaLibera;
    }
    
    public boolean getGuidaLibera(){
        return this.guidaLibera;
    }
    
    @Override
    public boolean controllaTarga(){
        return super.getTarga().matches("[A-Z]{2}[0-9]{5}");
    }
    
    @Override
    public String toString(){
        return super.toString()+", Guida libera = "+this.guidaLibera;
    }
}
