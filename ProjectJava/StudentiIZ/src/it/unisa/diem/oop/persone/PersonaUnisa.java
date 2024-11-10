package it.unisa.diem.oop.persone;

public abstract class PersonaUnisa extends Persona {
    private String matricola;
    
    public PersonaUnisa() {
        this("no name", "no surname", "no codice fiscale", "no matricola");
    } 
    
    public PersonaUnisa(String nome, String cognome, String codiceFiscale, String matricola) {
        super(nome, cognome, codiceFiscale);
        this.matricola = matricola;
    }    
    
    public abstract String getRuolo();
    
    public String getMatricola(){
        return this.matricola;
    }        
    
    @Override
    public String toString(){
        return this.getRuolo()+" -> "+super.toString()+" "+this.matricola;
    }
}
