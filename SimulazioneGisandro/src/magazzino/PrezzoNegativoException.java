package magazzino;

public class PrezzoNegativoException extends Exception {
    public PrezzoNegativoException() {}

    public PrezzoNegativoException(String msg) {
        super(msg);
    }
}
