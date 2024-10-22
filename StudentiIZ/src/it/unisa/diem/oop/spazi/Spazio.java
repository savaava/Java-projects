package it.unisa.diem.oop.spazi;

public abstract class Spazio implements Accessibile {
    private String nome;
    private int maxPosti;
    
    public Spazio(String nome, int maxPosti) {
        this.nome = nome;
        this.maxPosti = maxPosti;
    }
    
    private static int ciaone(){
        return 1;
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