import java.time.LocalDate;
import java.time.Period;

public class ProdottoAlimentare extends Prodotto {
    LocalDate dataScadenza;
    
    public ProdottoAlimentare(String codice, String descrizione, double prezzo, LocalDate dataScadenza){
        super(codice, descrizione, prezzo);
        this.dataScadenza=dataScadenza;
    }
    
    public LocalDate getDataScadenza(){
        return dataScadenza;
    }
    
    @Override
    public double applicaSconto(){
        Period period = LocalDate.now().until(dataScadenza);
        if(period.getYears()>0 || period.getMonths()>0 || period.getDays()>10)
            return super.getPrezzo();
        return super.getPrezzo()-0.2*super.getPrezzo();
    }
    
    @Override
    public String toString(){
        return super.toString()+"\ndata scadenza="+dataScadenza.toString();
    }
}
