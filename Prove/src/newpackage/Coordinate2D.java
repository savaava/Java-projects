package newpackage;

import exceptions.AccessibileUnoException;

public class Coordinate2D implements Accessibile {
    float x;
    private final float y;
    
    public Coordinate2D(){
        this(0.99f, 0.99f);
    }
    
    public Coordinate2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public float DistanzaDalCentro() throws AccessibileUnoException {
        if(x<1 || y<1) throw new AccessibileUnoException("CIAO SONO L'ECCEZIONE");
        return (float)Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    
    @Override
    public String toString(){
        return "x: "+this.x+"\ny: "+this.y+"\n";
    }
}
