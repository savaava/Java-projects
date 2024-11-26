package it.unisa.diem.oop.persone;

import java.io.Serializable;

public class Persona implements Clonabile<Persona>, Comparable<Persona>, Serializable {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int età;
    
    public Persona(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }   
    
    public final String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }
    
    public void setEta(int età){
        this.età = età;
    }
    public int getEta(){
        return this.età;
    }
    
    @Override
    public String toString(){
        return "Persona - "+this.nome+" "+this.cognome+" "+this.codiceFiscale;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false; //proprietà simmetrica
        
        Persona p = (Persona)obj;
        return p.codiceFiscale.equals(this.codiceFiscale);
    }

    @Override
    public Persona clona() {
        return new Persona(this.nome, this.cognome, this.codiceFiscale);
    }
    
    @Override
    public int hashCode(){
        return this.codiceFiscale.hashCode();       
    }
    
    
//    @Override
//    public int hashCode(){
//        int hash = 7;
//        hash = 79 * hash + this.nome.hashCode();
//        hash = 79 * hash + this.cognome.hashCode();
//        hash = 79 * hash + this.codiceFiscale.hashCode();
//        return hash;
//    }
    
    @Override
    public int compareTo(Persona o){
        return this.codiceFiscale.compareTo(o.codiceFiscale);
    }
}
