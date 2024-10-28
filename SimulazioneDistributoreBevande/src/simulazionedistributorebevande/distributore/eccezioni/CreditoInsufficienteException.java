package simulazionedistributorebevande.distributore.eccezioni;

public class CreditoInsufficienteException extends Exception {
    public CreditoInsufficienteException() {}

    public CreditoInsufficienteException(String msg) {
        super(msg);
    }
}
