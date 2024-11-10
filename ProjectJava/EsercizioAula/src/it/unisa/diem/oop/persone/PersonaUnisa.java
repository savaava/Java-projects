package it.unisa.diem.oop.persone;

public class PersonaUnisa extends Persona {
    private String matricola;
    
    public PersonaUnisa(){
        this("NESSUN nome", "NESSUN cognome", "NESSUN codice fiscale", "NESSUNA matricola");
    }
    
    public PersonaUnisa(String nome, String cognome, String codiceFiscale, String matricola){
        super(nome, cognome, codiceFiscale);
        this.matricola = matricola;
    }
    
    public String getMatricola(){
        return this.matricola;
    }
}
