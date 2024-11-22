package simulazioneaeroportoio;

public class AereoAMotore extends Aeromobile {
    private int numRotori;
    
    public AereoAMotore(String codice, int numRotori){
        super(codice);
        this.numRotori = numRotori;
    }

    public int getNumRotori() {
        return numRotori;
    }
    
    @Override
    public String toString(){
        return super.toString()+" - Tipo = Aereo a motore - Numero di rotori = "+numRotori;
    }
}
