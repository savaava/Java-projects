package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.Persona;

public interface Accessibile {
    /* 
    le interfacce hanno nomi di aggettivi (Accessibile, iterabile, clonabile, confrontabile) le interfacec
    sono astrazioni comportamentali a differenza delle classe astratte che comunque modella qualcosa 
    Accessibile -> è uno spazio in cui c'è la capacità di poter entrare e uscire
    
    SOLO METODI ASTRATTI:
    E' QUINDI SOTTOINTESO CHE SIANO abstract
    
    Qualsiasi classe che ha l'interfaccia allora deve rispettare questo contratto:
    ridefinire questi metodi
    Quando definisco la classe che implementa l'interfaccia allora deve rispettare il contratto
    All'inizio l'interfaccia era l'insieme dei metodi pubblici
    
    aulaPiena
    aulaVuota
    non li voglio mettere 
    */
    
    void entra(Persona p);
    Persona esce();
    
}
