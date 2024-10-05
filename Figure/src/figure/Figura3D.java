package figure;

public abstract class Figura3D extends FiguraGeometrica {
    
    public Figura3D(String nomeFigura, int numeroLati) {
        super(nomeFigura, numeroLati);
    }
    
    
    public abstract float calcolaArea();
    public abstract float calcolaVolume();
    
    
    @Override
    public String toString(){
        return super.toString()+"\nFigura 3D";
    }   
}
