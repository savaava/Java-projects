package registroesami;

public class CodiceNonValidoException extends RuntimeException {
    public CodiceNonValidoException() {}

    public CodiceNonValidoException(String msg) {
        super(msg);
    }
}
