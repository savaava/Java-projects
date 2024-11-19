package tmpaiuto;

public class Persona implements Comparable<Persona> {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int eta;
    
    public Persona(String nome, String cognome, String codiceFiscale, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.eta = eta;
    }

    public int getEta(){
        return eta;
    }
    
    public void setEta(int eta){
        this.eta=eta;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(getClass() != obj.getClass())
            return false;
        Persona objPersona = (Persona)obj;
        return this.codiceFiscale.equalsIgnoreCase(objPersona.codiceFiscale);
    }
    
    @Override
    public int compareTo(Persona o) {
        return codiceFiscale.compareToIgnoreCase(o.codiceFiscale);
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 37 * hash + this.codiceFiscale.toUpperCase().hashCode();
        return hash;
    }
    
    @Override
    public String toString(){
        return "\nPersona{"+"nome="+nome+", cognome="+cognome+", codiceFiscale="+codiceFiscale+", eta="+eta+"}";
    }
}

