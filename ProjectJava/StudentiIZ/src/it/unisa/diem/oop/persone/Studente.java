package it.unisa.diem.oop.persone;

import it.unisa.diem.oop.spazi.exceptions.VotoNonConsentitoException;

public class Studente extends PersonaUnisa {
    private float votoMedio;
    
    public Studente() {
        this("no name", "no surname", "no codice fiscale", "no matricola", 0F);
    }
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola, float votoMedio){
        super(nome, cognome, codiceFiscale, matricola);
        if(votoMedio<18) throw new VotoNonConsentitoException("Voto medio non consentito");
        
        this.votoMedio = votoMedio; 
    }
    
    public float getVotoMedio(){
        return this.votoMedio;
    }
    
    @Override
    public String toString(){
        return super.toString()+" "+this.votoMedio;
    }

    @Override
    public String getRuolo() {
        return "Studente";
    }
}
