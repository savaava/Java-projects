package registroesami;

public class VotoNonValidoException extends RuntimeException {
    public VotoNonValidoException() {}

    public VotoNonValidoException(String msg) {
        super(msg);
    }
}
