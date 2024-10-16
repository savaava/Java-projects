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
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        //if(this.getClass() != obj.getClass()) return false; //proprietà simmetrica x=y -> y=x
        if(!(obj instanceof Persona)) return false;
        
        Persona p = (Persona)obj;
        return p.codiceFiscale.equals(this.codiceFiscale);
        
        /*VERRA' CHIESTO UN EQUALS -> devo fare i vari casi, nella traccia troverò:
        due cose sono uguali se... (hanno lo stesso codice fiscale)*/
    }

    @Override
    public Persona clona() { /*nell'override ci metto il tipo Persona specifico della seguente classe*/
        return new Persona(this.nome, this.cognome, this.codiceFiscale);
    }
}
