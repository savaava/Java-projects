package it.unisa.diem.oop.persone;

public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    
    public Persona(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }   
    
    /*per ora non arrichiamo la classe con setter e getter
    questa è la classe madre: 
    SPECIALIZZAZIONE -> Da classe madre a classe figlie
    GENERALIZZAZIONE -> Da le classi figlie o sottoclassi a classe madre (al contrario)
    */
    
    /**/
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
