package it.unisa.diem.oop.persone;

public class Studente extends PersonaUnisa {
    private float votoMedio;
    
    public Studente() {
        this("no name", "no surname", "no codice fiscale", "no matricola", 0F);
    }
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola, float votoMedio){
        super(nome, cognome, codiceFiscale, matricola);
        this.votoMedio = votoMedio; 
    }
    
    public float getVotoMedio(){
        return this.votoMedio;
    }
}
