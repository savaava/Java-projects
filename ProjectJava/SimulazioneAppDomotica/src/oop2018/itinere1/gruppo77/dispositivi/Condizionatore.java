package oop2018.itinere1.gruppo77.dispositivi;

public class Condizionatore extends AttuatoreRegolabile{
    public Condizionatore(int id, double livelloMin, double livelloMax, double livello) throws LivelloNonValidoException{
        super(id, livelloMin, livelloMax, livello);
        
        if(livello<livelloMin || livello>livelloMax)
            throw new LivelloNonValidoException("livelli non validi !!");
    }
    
    @Override
    public String toString(){
        return super.toString()+" - Tipo: Condizionatore";
    }
}
