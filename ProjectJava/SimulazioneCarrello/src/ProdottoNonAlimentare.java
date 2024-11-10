import java.time.LocalDate;

public class ProdottoNonAlimentare extends Prodotto {    
    private final String materiale;
    
    public ProdottoNonAlimentare(String codice, String descrizione, double prezzo, String materiale){
        super(codice, descrizione, prezzo);
        this.materiale=materiale;
    }
    
    public String getMateriale(){
        return materiale;
    }
    
    public boolean isRiciclabile(){
        return materiale.equalsIgnoreCase("vetro") || materiale.equalsIgnoreCase("carta") || materiale.equalsIgnoreCase("cotone");
    }
    
    @Override
    public double applicaSconto(){
        if(this.isRiciclabile())
            return super.getPrezzo()-0.1*super.getPrezzo();
        return super.getPrezzo();
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nmateriale="+materiale;
    }
}
