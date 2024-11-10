package magazzino;

public class ScortaNonTrovataException extends Exception {
    public ScortaNonTrovataException() {}

    public ScortaNonTrovataException(String msg) {
        super(msg);
    }
}
