package it.unisa.diem.oop.persone;

public class Studente extends PersonaUnisa{
    private float votoMedio;
    
    public Studente(){
        this("NESSUN nome", "NESSUN cognome", "NESSUN codice fiscale", "NESSUNA matricola", 0F);
    }
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola, float votoMedio){
        super(nome, cognome, codiceFiscale, matricola);
        this.votoMedio = votoMedio;
    }
    
    public float getVotoMedio(){
        return this.votoMedio;
    }
}
