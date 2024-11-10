package simulazionedistributorebevande.distributore.eccezioni;

public class BibitaNonPresenteException extends Exception  {
    public BibitaNonPresenteException() {}

    public BibitaNonPresenteException(String msg) {
        super(msg);
    }
}
