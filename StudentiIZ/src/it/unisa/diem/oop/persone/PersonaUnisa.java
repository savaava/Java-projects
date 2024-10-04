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
    
    /* una classe astratta può non avere metodi astratti o averne più d'uno
    
    il senso di questo metodo 
    le classi
    Ilmetodo astratto deve essere ridefinito dalle sottoclassi! Quindi
    OBBLIGO LE SOTTOCLASSI A RIDEFINIRE questo metodo
    QUESTO LO DOBBIAMO METTERE PERCHè IN QUESTO MODO OBBLIGHIAMO LE CLASSI DERIVATE (CONCRETE) A METTERLO
    E INOLTRE devono avere lo stesso nome, invece non mettere public abstract String getRuolo(); significa
    lasciare un'opzione alla sottoclasse di chiamarlo o meno e con che nome*/
    public abstract String getRuolo();
    
    public String getMatricola(){
        return this.matricola;
    }        
    
    @Override
    public String toString(){
        return super.toString()+" "+this.matricola;
    }
}
