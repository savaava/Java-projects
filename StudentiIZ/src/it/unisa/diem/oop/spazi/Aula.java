package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.*;

public class Aula extends Spazio {
    private Persona persone[];
    private int riemp;
    
    public Aula(){
        this("Nessun nome", 50);
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
    public void entra(Persona p){
        if(this.aulaPiena()){
            System.err.println("Non è possibile eseguire il metodo entra: ");
            System.err.println("L'aula ha raggiunto la capienza massima di persone: "+this.riemp+"/"+persone.length);
            return;
        }
        
        System.out.println("Entra studente #"+(this.riemp+1)+"...\n");
        this.persone[this.riemp++] = p;
    }
    
    @Override
    public Persona esce(){
        if(this.aulaVuota()){
            System.err.println("Non è possibile eseguire il metodo esce: ");
            System.err.println("L'aula non contiene persone: "+this.riemp+"/"+persone.length);
            return null;
        }
        
        /* riemp--;
        return this.persone[this.riemp];
        adeso però non è stato eliminato solo il riferimento e può essere solo sovrascritto 
        per migliorare si deve annullare il riferimento e si fa con una variabile d'appoiggio*/
        
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