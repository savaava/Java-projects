package it.unisa.diem.oop.persone;

public class Persona implements Clonabile<Persona> {
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
    
    /*esattamente come per toString da Object
    ricordati che l'argomento pure deve essere uguale*/
    @Override
    public boolean equals(Object obj){
        
        /*ricordiamoci le proprietà: prima di tutto NON DEVE ESSERE null: ()*/
        if(obj == null) return false; //questo ci ha detto la specifica
        
        if(this == obj) return true; //se è uguale allo stesso oggetto sono uguali per definizione
        
        //if(this.getClass() != obj.getClass()) return false; //proprietà simmetrica x=y -> y=x
        /*uno studente è una perosna ma una persona potrebbe non esserlo
        this si riferisce alla classe di appartenenza dell'istanza su cui è chiamato il metodo*/
        
        /*caso particolare per le collezioni*/
        if(!(obj instanceof Persona)) return false; // proprietà non simmetrica
        /*questo è un confronto assoluto non più relativo */
        /**/
        
        /*se arrivo fino a qui sono della stessa classe -> posso fare il downcast*/
        Persona p = (Persona)obj; //con una variabile locale p
        /*quali attributi devono avere uguali per dire che sono persone uguali: per me
        è sufficiente dire che per 2 persone sono uguali se tra gli attributi il codice fiscale è lo stesso*/
        /*p.codiceFiscale lo posso fare anche se è private perchè siamo nella classes*/
        return p.codiceFiscale.equals(this.codiceFiscale);
        /*VERRA' CHIESTO UN EQUALS -> devo fare i vari casi, nella traccia troverò:
        due cose sono uguali se... (hanno lo stesso codice fiscale)*/
    }

    @Override
    public Persona clona() { /*nell'override ci metto il tipo Persona specifico della seguente classe*/
        return new Persona(this.nome, this.cognome, this.codiceFiscale);
    }
}
