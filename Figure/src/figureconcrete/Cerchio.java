package figureconcrete;
import figure.Figura2D;

public class Cerchio extends Figura2D {
    private float raggio;
    
    /* costruttori */
    public Cerchio() {
        this("Nessun nome per il cerchio :/ ", 5F);
    }
    
    public Cerchio(String nomeFigura) {
        this(nomeFigura, 5F);
    }
    
    public Cerchio(float raggio) {
        this("Nessun nome per il cerchio :/ ", raggio);
    }
    
    public Cerchio(String nomeFigura, float raggio) {
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
    public float calcolaPerimetro() {
        return 2*(float)Math.PI*this.raggio;
    }
    
    @Override
    public float calcolaArea() {
        return (float)(Math.PI*Math.pow(this.raggio,2));
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nRaggio del cerchio: "+this.raggio;
    } 
}
