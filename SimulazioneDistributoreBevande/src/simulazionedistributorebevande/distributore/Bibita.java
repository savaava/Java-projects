package simulazionedistributorebevande.distributore;

public abstract class Bibita implements Comparable<Bibita> {
    private final String codice;
    private final String nome;
    private final double prezzo;
    private int numero;
    
    public Bibita(String codice, String nome, double prezzo, int numero){
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.numero = numero;
    }
    
    public String getCodice(){
        return codice;
    }
    public String getNome(){
        return nome;
    }
    public double getPrezzo(){
        return prezzo;
    }
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    
    @Override
    public int compareTo(Bibita otherBibita){
        return this.codice.compareTo(otherBibita.codice);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(!(obj instanceof Bibita))
            return false;
        
        Bibita bibitaObj = (Bibita)obj;
        return bibitaObj.codice.equals(this.codice);
    }
    
    @Override
    public String toString(){
        return "Bibita: "+nome+" - "+codice+" - Prezzo: "+prezzo+" € - numero: "+numero;
    }
}
