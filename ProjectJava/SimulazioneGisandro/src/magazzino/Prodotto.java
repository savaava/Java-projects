package magazzino;

public class Prodotto {
    private final String id;
    private final String nome;
    private final double prezzoUnitario;
    
    public Prodotto(String id, String nome, double prezzoUnitario) throws PrezzoNegativoException {
        if(prezzoUnitario < 0) throw new PrezzoNegativoException("PrezzoNegativoException");
        this.id = id;
        this.nome = nome;
        this.prezzoUnitario = prezzoUnitario;
    }
    
    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getPrezzoUnitario(){
        return prezzoUnitario;
    }
    
    
    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        
        Prodotto prodottoObj = (Prodotto)obj;
        return prodottoObj.id.equalsIgnoreCase(this.id);
    }
    
    @Override
    public String toString(){
        return "ID Prodotto="+id+", Nome="+nome+", Prezzo="+prezzoUnitario+"€";
    }
}
