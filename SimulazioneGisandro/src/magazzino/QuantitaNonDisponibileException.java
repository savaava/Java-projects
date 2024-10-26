package magazzino;

public class QuantitaNonDisponibileException extends Exception {
    public QuantitaNonDisponibileException() {}

    public QuantitaNonDisponibileException(String msg) {
        super(msg);
    }
}
