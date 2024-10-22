import java.util.List;
import java.util.ArrayList;

public class Carrello {
    List<Prodotto> carrello;
    
    public Carrello(){
        carrello = new ArrayList<>();
    }
    
    public void addProdotto(Prodotto p){
        carrello.add(p);
    }
    
    public double getTotale(){
        double totale=0;
        
        for(Prodotto pi : carrello){
            totale+=pi.getPrezzo();
        }
        return totale;
    }
    
    public double getTotaleScontato(){
        double scontato=0;
        
        for(Prodotto pi : carrello){
            scontato+=pi.applicaSconto();
        }
        return scontato;
    }
    
    public void removeProdotto(Prodotto p){
        carrello.remove(p);
    }
    
    public Prodotto getProdotto(int idx){
        return carrello.get(idx);
    }
    
    @Override
    public String toString(){
        return carrello.toString()+"\ntotale="+getTotale()+"\nscontato="+getTotaleScontato()+"\n";
    }
}
