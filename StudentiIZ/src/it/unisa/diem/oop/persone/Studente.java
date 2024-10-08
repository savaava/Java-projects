package it.unisa.diem.oop.persone;

public class Studente extends PersonaUnisa {
    private float votoMedio;
    
    public Studente() {
        this("no name", "no surname", "no codice fiscale", "no matricola", 0F);
    }
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola, float votoMedio){
        super(nome, cognome, codiceFiscale, matricola);
        /* non accetto un voto medio < 18 : eccezione!!*/
        if(votoMedio<18){
            throw new RuntimeException("Voto medio non consentito");
        }
        this.votoMedio = votoMedio; 
    }
    
    public float getVotoMedio(){
        return this.votoMedio;
    }
    
    /*@Override
    public String getNome() {
        return "giggino";
    }*/
    
    @Override
    public String toString(){
        return super.toString()+" "+this.votoMedio;
    }

    /*Se la sottoclasse studente fosse stata astratta pur essa allora non c'era bisogno di
    scrivere getRuolo col tipo abstract*/
    @Override
    public String getRuolo() {
        return "Studente";
    }
}
