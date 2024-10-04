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
    
    /*DEVE ESSERE UGUALE, ALTRIMENTI C'è OVERLOADING: */
    @Override
    /*è raccomandato perchè è un modo di contrassegnare metodi classi metodi o attributi
    ci sono i processori di annotazioni che fanno controlli di coerenza, serve allo
    sviluppatore e non alla JVM
    Serve solo per segnalare ma non dà errore di compilazione */
    public String toString(){
        return "Persona - "+this.nome+" "+this.cognome+" "+this.codiceFiscale;
    }
}
