package registroesami;

public class DataNonValidaException extends RuntimeException {
    public DataNonValidaException() {}

    public DataNonValidaException(String msg) {
        super(msg);
    }
}
