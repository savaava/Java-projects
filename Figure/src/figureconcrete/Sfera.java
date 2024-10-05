package figureconcrete;
import figure.Figura3D;

public class Sfera extends Figura3D {
    private float raggio;
    
    /* costruttori */
    public Sfera(){
        this("Nessun nome per la sfera :/ ", 5f);
    }
    
    public Sfera(String nomeFigura){
        this(nomeFigura, 5F);
    }
    
    public Sfera(float raggio){
        this("Nessun nome per la sfera :/ ", raggio);
    }
    
    public Sfera(String nomeFigura, float raggio){
        super(nomeFigura, 0);
        this.raggio = raggio;
    }
    
    /* metodi */
    public float getRaggio(){
        return this.raggio;
    }
    
    public void setRaggio(float raggio){
        this.raggio = raggio;
    }
    
    /* ridefinizioni */    
    @Override
    public float calcolaArea() {
        return (float)(4*Math.PI*Math.pow(this.raggio, 2));
    }
    
    @Override
    public float calcolaVolume() {
        return (float)((4.0/3)*Math.PI*Math.pow(this.raggio, 3));
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nRaggio della sfera: "+this.raggio;
    } 
}
