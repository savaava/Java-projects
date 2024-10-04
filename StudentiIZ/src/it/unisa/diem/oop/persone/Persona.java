package it.unisa.diem.oop.persone;

public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    
    public Persona(){
        this("no name", "no surname", "no codice fiscale");
    }
    
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
    
    @Override
    public String toString(){
        return "Persona - "+this.nome+" "+this.cognome+" "+this.codiceFiscale;
    }
}
