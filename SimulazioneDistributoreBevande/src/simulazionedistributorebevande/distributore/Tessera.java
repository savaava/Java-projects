package simulazionedistributorebevande.distributore;

public class Tessera implements Comparable<Tessera> {
    private final int codice;
    private double saldo;
    
    public Tessera(int codice, double saldo){
        this.codice = codice;
        this.saldo = saldo;
    }
    
    public int getCodice(){
        return codice;
    }
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    
    @Override
    public int compareTo(Tessera otherTessera){
        return (this.codice - otherTessera.codice);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != Tessera.class)
            return false;
        
        Tessera tesseraObj = (Tessera)obj;
        return (tesseraObj.codice == this.codice);
    }
    
    @Override
    public String toString(){
        return "Tessera: "+codice+" - Saldo: "+saldo+" €";
    }
}
