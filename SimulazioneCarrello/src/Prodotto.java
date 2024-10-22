import java.time.LocalDate;

public abstract class Prodotto {
    private final String codice;
    private final String descrizione;
    private final double prezzo;
    
    public Prodotto(String codice, String descrizione, double prezzo){
        this.codice=codice;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
    }
    
    public String getCodice(){
        return codice;
    }
    public String getDescrizione(){
        return descrizione;
    }
    public double getPrezzo(){
        return prezzo;
    }
    
    public abstract double applicaSconto();
    
    @Override
    public String toString(){
        return "\n\nProdotto:\n"+"codice="+codice+"\ndescrizione="+descrizione+"\nprezzo="+prezzo;
    }
}
