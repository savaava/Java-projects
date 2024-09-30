package it.unisa.diem.oop.persone;

public class Studente extends PersonaUnisa {
    private float votoMedio;
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola, float votoMedio){
        super(nome, cognome, codiceFiscale, matricola);
        this.votoMedio = votoMedio; 
    }
    
    /*metti il get per il voto medio
    es: Aula*/
}
