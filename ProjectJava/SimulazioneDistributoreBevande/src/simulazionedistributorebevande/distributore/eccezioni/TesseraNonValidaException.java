package simulazionedistributorebevande.distributore.eccezioni;

public class TesseraNonValidaException extends Exception {
    public TesseraNonValidaException() {}

    public TesseraNonValidaException(String msg) {
        super(msg);
    }
}
