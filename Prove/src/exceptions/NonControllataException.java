package exceptions;

public class NonControllataException extends RuntimeException {
    public NonControllataException() {}

    public NonControllataException(String msg) {
        super(msg);
    }
}
