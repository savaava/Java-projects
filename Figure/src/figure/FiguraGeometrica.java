package figure;

public abstract class FiguraGeometrica {
    private String nomeFigura;
    private int numeroLati;
    
    public FiguraGeometrica(String nomeFigura, int numeroLati) {
        this.nomeFigura = nomeFigura;
        this.numeroLati = numeroLati;
    }
    
    
    @Override
    public String toString(){
        return "Nome figura geometrica: "+this.nomeFigura+"\nNumero dei lati: "+this.numeroLati;
    }
}
