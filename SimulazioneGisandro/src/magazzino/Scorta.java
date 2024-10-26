package magazzino;

import java.time.LocalDate;

public class Scorta {
    private final Prodotto prodotto;
    private int quantitaDisponibile;
    private LocalDate dataUltimoAggiornamento;
    
    public Scorta(Prodotto prodotto, int quantitaDisponibile, LocalDate dataUltimoAggiornamento) throws QuantitaNegativaException {
        if(quantitaDisponibile < 0) throw new QuantitaNegativaException("QuantitaNegativaException");
        
        this.prodotto = prodotto;
        this.quantitaDisponibile = quantitaDisponibile;
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }
    
    public Prodotto getProdotto(){
        return prodotto;
    }
    public int getQuantitaDisponibile(){
        return quantitaDisponibile;
    }
    public LocalDate getDataUltimoAggiornamento(){
        return dataUltimoAggiornamento;
    }
    
    public void setQuantitaDisponibile(int quantita){
        quantitaDisponibile = quantita;
    }
    public void setDataUltimoAggiornamento(LocalDate data){
        dataUltimoAggiornamento = data;
    }
            
            
    @Override
    public int hashCode(){
        return this.prodotto.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        
        Scorta scortaObj = (Scorta)obj;
        return scortaObj.prodotto.equals(this.prodotto);
    }
    
    @Override
    public String toString(){
        return this.prodotto+", Quantità="+quantitaDisponibile+", Ultimo Aggiornamento="+dataUltimoAggiornamento;
    }        
}
