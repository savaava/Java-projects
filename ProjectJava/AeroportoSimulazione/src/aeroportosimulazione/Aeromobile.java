package aeroportosimulazione;

public abstract class Aeromobile implements java.io.Serializable {
    private final String codice;
    private final int numeroSequenziale;
    
    private static int cont = 0;
    
    public Aeromobile(String codice){
        this.codice = codice;
        numeroSequenziale = ++cont;
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
