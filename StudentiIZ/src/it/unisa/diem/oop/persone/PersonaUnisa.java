package it.unisa.diem.oop.persone;

public class PersonaUnisa extends Persona {
    /*non voglio riscrivere gli attributi quindi aggiungo solo matricola*/
    private String matricola;
    /*key word: extends per dire che 
    personaunisa è una specializzazione / estensione di persona
    quando definisco un'estensione devo definire lo stato (nome, cognome, codicefiscale) ->
    ho bisogno di usare un costruttore per inizializzare gli attributi della classe madre persona*/
    
    public PersonaUnisa() {
        this("no name", "no surname", "no codice fiscale", "no matricola");
    } 
    
    public PersonaUnisa(String nome, String cognome, String codiceFiscale, String matricola) {
        /*devo gestire i parametri di persona come faccio ?*/
        // come quando uso this per riferirmi a un altro costruttore
        super(nome, cognome, codiceFiscale);
        /*è la prima cosa: invocare il costruttore della super classe / classe madre
        super = istanzioare l'oggeto della super classe
        posso accedere solo agli attributi PUBLIC e non PRIVATE*/
        this.matricola = matricola;
    }    
    
    /*
    PRIVATE -> non posso prendere gli attributi, metodi
    tutti i metodi PUBLIC (metodo get per la classe persona) vengono ereditati
    nella sottoclasse posso accedere a TUTTI gli ATTRIBUTI e METODI che sono PUBLIC, oppure
    che sono con specificatore di default perchè siamo nello stesso package*/
    
    public String getMatricola(){
        //super.nome = "ciao"; -> no perchè è privato
        return this.matricola;
    }        
}
