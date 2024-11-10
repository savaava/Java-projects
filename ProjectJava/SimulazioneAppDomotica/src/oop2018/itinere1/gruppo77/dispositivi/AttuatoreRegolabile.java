package oop2018.itinere1.gruppo77.dispositivi;

public abstract class AttuatoreRegolabile extends Attuatore {
    private double livello; 
    private final double livelloMin; 
    private final double livelloMax; 
    
    public AttuatoreRegolabile(int id, double livelloMin, double livelloMax, double livello) /*throws LivelloNonValidoException*/{
        super(id);
        
        //if(livello<livelloMin || livello>livelloMax) throw new LivelloNonValidoException("livelli non validi !!");
        
        this.livello=livello;
        this.livelloMin=livelloMin;
        this.livelloMax=livelloMax;
    }
    
    public double getLivello(){
        return livello;
    }
    public double getLivelloMin(){
        return livelloMin;
    }
    public double getLivelloMax(){
        return livelloMax;
    }
    
    public void setLivello(double livello){
        this.livello=livello;
    }
    
    
    @Override
    public String toString(){
        return super.toString()+", Attuatore regolabile Liv/Min/Max = "+livello+"/"+livelloMin+"/"+livelloMax;
    }
}
