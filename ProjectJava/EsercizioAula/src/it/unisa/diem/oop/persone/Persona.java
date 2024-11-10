package it.unisa.diem.oop.persone;

public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    
    public Persona(){
        this("NESSUN nome", "NESSUN cognome", "NESSUN codice fiscale");
    }
    
    public Persona(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }
}
