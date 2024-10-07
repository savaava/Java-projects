package it.unisa.diem.oop.spazi;

public abstract class Spazio implements Accessibile {
    private String nome;
    private int maxPosti;
    /*
    Per poter implementare -> deve essere astratto e deve ridefinire i metodi
    Spazio adesso essendo asttratta può non ridefinire i metodi,
    lo faranno direttamente le aule concrete
    è una proprietà dell'aula maxPosti
    
    facciamo il costruttore perchè 
    */
    
    public Spazio(String nome, int maxPosti) {
        this.nome = nome;
        this.maxPosti = maxPosti;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getMaxPosti(){
        return this.maxPosti;
    }
    
    public abstract String getTipo();
    
    @Override
    public String toString(){
        return this.getTipo()+": "+this.nome+"capienza max: "+this.maxPosti;
    }
}