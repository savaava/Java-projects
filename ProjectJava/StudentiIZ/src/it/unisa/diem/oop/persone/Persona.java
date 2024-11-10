package it.unisa.diem.oop.persone;

public class Persona implements Clonabile<Persona>, Comparable<Persona> {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int età;
    
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
        if(this.getClass() != obj.getClass()) return false; //proprietà simmetrica x=y -> y=x
        //if(!(obj instanceof Persona)) return false;
        
        Persona p = (Persona)obj;
        return p.codiceFiscale.equals(this.codiceFiscale);
        
        /*VERRA' CHIESTO UN EQUALS -> devo fare i vari casi, nella traccia troverò:
        due cose sono uguali se... (hanno lo stesso codice fiscale)*/
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
        /*anche questo metodo sfrutta equals, perchè se le due persone sono uguali allora restituisce 0
        potrebbe esserci la situazione: equals dipende da CF e comapreTo dipende dall'età quindi c'è
        incoerenza -> devo far in modo che valutano gli stessi attributi entrambi i metodi */
        //return this.codiceFiscale.compareTo(o.codiceFiscale);
        /*il compare to della stringa si basa SOLO SUL CODICE FISCALE, la compareTo deve
        essere compatibile con equals (che adesso non viene utilizzato)
        per mantenre lo stesso comportamento dell' hashSet allora dobbiamo scrivere
        codice simile a equals-> se i CF sono uguali allora verifico se le classi 
        sono diverse tra loro */
        
//        if(! this.cognome.equals(o.cognome))
//            return this.cognome.compareTo(o.cognome);
        return this.codiceFiscale.compareTo(o.codiceFiscale);
        
        /*se ho un'attributo numerico potrei fare una differenza se si tratta di interi,
        invece per numeri decimali -> usiamo le classi wrapper*/
    }
}
