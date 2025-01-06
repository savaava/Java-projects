package it.unisa.diem.oop.threadgestioneristorante;

public class Ordinazione implements java.io.Serializable{
    private String piatto;
    private int tavolo;
    private int quantita;
    
    public Ordinazione(String piatto, int tavolo, int quantita){
        this.piatto = piatto;
        this.tavolo = tavolo;
        this.quantita = quantita;
    }
    
    public String getPiatto(){
        return piatto;
    }
    public int getTavolo(){
        return tavolo;
    }
    public int getQuantita(){
        return quantita;
    }
    
    public void setPiatto(String piatto){
        this.piatto = piatto;
    }
    public void setTavolo(int tavolo){
        this.tavolo = tavolo;
    }
    public void setQuantita(int quantita){
        this.quantita = quantita;
    }
    
    @Override
    public String toString(){
        return "Piatto: "+piatto+", Tavolo: "+tavolo+", Quantità: "+quantita;
    }
}
