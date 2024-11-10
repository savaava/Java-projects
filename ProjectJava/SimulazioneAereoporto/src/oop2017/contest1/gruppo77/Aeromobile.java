package oop2017.contest1.gruppo77;

public abstract class Aeromobile {
    private final String codice;
    private final int numeroSequenziale;
    private static int allocati=0;
    
    public Aeromobile(String codice){
        allocati++;
        this.codice=codice;
        this.numeroSequenziale=allocati;
    }
    
    public String getCodice(){
        return codice;
    }
    public int getNumeroSequenziale(){
        return numeroSequenziale;
    }
    
    
    @Override
    public String toString(){
        return "Aeromobile n."+numeroSequenziale+" - Codice = "+codice;
    }    
}
