package magazzino;

public class QuantitaNegativaException extends Exception {
    public QuantitaNegativaException() {}

    public QuantitaNegativaException(String msg) {
        super(msg);
    }
}
