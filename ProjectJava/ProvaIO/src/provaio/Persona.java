package provaio;

public class Persona implements Comparable<Persona>, java.io.Serializable {
    private final String nome;
    private final String cognome;
    private final String codiceFiscale;
    private final int eta;
    private final float altezza;
    
    public Persona(String nome, String cognome, String codiceFiscale, int eta, float altezza){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.eta = eta;
        this.altezza = altezza;
    }   
    
    public final String getNome(){
        return nome;
    }    
    public String getCognome(){
        return cognome;
    }    
    public String getCodiceFiscale(){
        return codiceFiscale;
    }
    public int getEta(){
        return eta;
    }
    public float getAltezza(){
        return altezza;
    }
    
    @Override
    public int hashCode(){
        return codiceFiscale.toLowerCase().hashCode();       
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        
        Persona p = (Persona)obj;
        return p.codiceFiscale.equalsIgnoreCase(codiceFiscale);
    }
    
    @Override
    public int compareTo(Persona o){
        return codiceFiscale.compareToIgnoreCase(o.codiceFiscale);
    }
    
    @Override
    public String toString(){
        return "("+this.nome+"-"+this.cognome+"-"+this.codiceFiscale+"-"+eta+"-"+altezza+"m)\n";
    }
}

