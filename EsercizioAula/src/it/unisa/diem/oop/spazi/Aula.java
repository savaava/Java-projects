package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.*;

public class Aula {
    private int maxPosti;
    private int currDim;
    Studente studenti[];
    
    public Aula(){
        this(50);
    }
    
    public Aula(int maxPosti) {
        this.maxPosti = maxPosti;
        this.currDim = 0; 
        this.studenti = new Studente[this.maxPosti];
    }
    
    public boolean aulaPiena(){
        return (this.currDim == this.maxPosti);
    }
    
    public boolean aulaVuota(){
        return (this.currDim == 0);
    }
    
    public void entra(Studente s){
        if(this.aulaPiena()){
            System.err.println("Non è possibile eseguire il metodo entra: ");
            System.err.println("L'aula ha raggiunto la capienza massima di studenti: "+this.currDim+"/"+this.maxPosti);
            return;
        }
        
        this.studenti[currDim++] = s;
    }
    
    public void esce(){
        if(this.aulaVuota()){
            System.err.println("Non è possibile eseguire il metodo esce: ");
            System.err.println("L'aula non contiene studenti: "+this.currDim+"/"+this.maxPosti);
            return;
        }
        
        this.studenti[--currDim] = null;
    }
    
    private StringBuffer formattazioneStampa(int i){
        StringBuffer str;
        str = new StringBuffer();
        
        str.append("-Nome: ");
        str.append(this.studenti[i].getNome());
        str.append("\n");
        str.append("-Cognome: ");
        str.append(this.studenti[i].getCognome());
        str.append("\n");
        str.append("-Codice fiscale: ");
        str.append(this.studenti[i].getCodiceFiscale());
        str.append("\n");
        str.append("-Matricola: ");
        str.append(this.studenti[i].getMatricola());
        str.append("\n");
        str.append("-Voto medio: ");
        str.append(this.studenti[i].getVotoMedio());
        
        return str;
    }
    
    public void getInfoAula(){
        if(this.aulaVuota()){
            System.out.println("L'aula non contiene studenti: "+this.currDim+"/"+this.maxPosti+"\n");
            return;
        }
        
        System.out.println("L'aula contiene "+this.currDim+" studenti / "+this.maxPosti+" capienza massima");
        System.out.println("--------------------------------------");
        for(int i=0;  i<this.currDim;  i++){
            System.out.println("Studente #"+(i+1)+":");
            System.out.println(this.formattazioneStampa(i));
            System.out.println("--------------------------------------");
        }
        System.out.println();
    }
}


/*
A partire dalla definizione delle classi Persona e Studente, è richiesto di definire ed implementare la seguente classe:

-  Aula : la classe Aula modella lo spazio "Aula" che ha il seguente vincolo: gli studenti devono occupare i posti liberi partendo dal fondo, di conseguenza il primo studente ad entrare sarà l'ultimo ad uscire. La classe Aula ha come attributi almeno maxPosti che rappresenta il numero massimo di studenti ospitabili e studenti, un array che contiene gli studenti presenti in aula.

La classe Aula dovrà prevedere un costruttore Aula(int maxPosti)  che ha come parametro  il numero massimo di studenti da ospitare ed i seguenti metodi:

-  ?? aulaPiena() :  restituisce un booleano di valore vero se l'aula è piena

-  ?? aulaVuota() : restituisce un booleano di valore vero se l'aula è vuota

- ?? entra( Studente s)  :  "aggiunge" uno studente ai presenti in aula

- Studente esce() :   "rimuove" uno studente dai presenti

- String getInfoAula() : restituisce una rappresentazione sotto forma di stringa dell'elenco degli studenti presenti in aula

La classe Aula dovrà essere collocata nel package it.unisa.diem.oop.spazi

Prevedere una classe TestAula nel package spazi per verificare il funzionamento del codice prodotto.
*/
