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
            /*deve essere non controllata NullPointerException OutOfBoundException
            quindi è meglio chiamare la classe dell'eccezione col nome del problema
            che si è verificato:*/
            throw new VotoNonConsentitoException("Voto medio non consentito");
            //throw new Exception("Voto medio non consentito");
            /*non me lo fa fare perchè bisogna gestirla*/
            /*
            La classe deve ereditare Exception o RuntimeException
            fine delle eccezioni non controllate
            */
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
