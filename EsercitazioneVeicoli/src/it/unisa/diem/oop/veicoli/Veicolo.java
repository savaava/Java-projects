package it.unisa.diem.oop.veicoli;

public abstract class Veicolo {
    private final String numTelaio;
    private final String modello;
    private final String alimentazione;
    private String targa;
    
    public Veicolo(String numTelaio, String modello, String alimentazione, String targa){
        this.numTelaio = numTelaio;
        this.modello = modello;
        this.alimentazione = alimentazione;
        this.targa = targa;
    }
    
    public String getNumTelaio(){
        return this.numTelaio;
    }
    
    public String getModello(){
        return this.modello;
    }
    
    public String getAlimentazione(){
        return this.alimentazione;
    }
    
    public String getTarga(){
        return this.targa;
    }
    
    public void setTarga(String targa){
        this.targa = targa;
    }
    
    public abstract boolean controllaTarga();
    
    @Override
    public String toString(){
        return "Telaio = "+this.numTelaio+", Modello = "+this.modello+", Alimentazione = "+this.alimentazione+", Targa = "+this.targa;
    }
}
