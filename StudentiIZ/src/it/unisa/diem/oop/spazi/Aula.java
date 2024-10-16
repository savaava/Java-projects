package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.spazi.exceptions.AulaVuotaException;
import it.unisa.diem.oop.spazi.exceptions.AulaPienaException;
import it.unisa.diem.oop.persone.*;

public class Aula extends Spazio {
    private Persona persone[];
    private int riemp;
    
    public Aula(){
        this("Nessun nome dell'Aula ", 50);
    }
    
    public Aula(String nome, int maxPosti) {
        super(nome, maxPosti);
        this.persone = new Persona[maxPosti];
        this.riemp = 0; 
    }
    
    private boolean aulaPiena(){
        return (this.riemp == super.getMaxPosti());
    }
    
    private boolean aulaVuota(){
        return (this.riemp == 0);
    }
    
    @Override
    /*qui sono preciso e uso AulaPienaExc*/
    public void entra(Persona p) throws AulaPienaException {
        if(this.aulaPiena()) throw new AulaPienaException("Aula piena! NON PUO' ENTRARE NESSUNO\n");
        
        System.out.println("Entra studente #"+(this.riemp+1)+"...\n");
        this.persone[this.riemp++] = p;
    }
    
    @Override
    public Persona esce() throws AulaVuotaException {
        if(this.aulaVuota()) throw new AulaVuotaException("Aula vuota! NON PUO' USCIRE NESSUNO\n"); 
        
        System.out.println("Esce studente #"+(this.riemp)+"...\n");
        Persona p = persone[--riemp];
        persone[riemp] = null;
        return p;
    }
    
    @Override
    public String getTipo() {
        return "Aula";
    }
    
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer(super.toString()).append("\n");
        for(int i=0;  i<riemp;  i++){
            sb.append(persone[i]).append("\n");
        }
        return sb.toString();
    }
}