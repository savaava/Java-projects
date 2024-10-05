package figure;

public abstract class Figura2D extends FiguraGeometrica {
    
    public Figura2D(String nomeFigura, int numeroLati) {
        super(nomeFigura, numeroLati);
    }
    
    
    public abstract float calcolaPerimetro();
    public abstract float calcolaArea();
    
    
    @Override
    public String toString(){
        return super.toString()+"\nFigura 2D";
    }
}
