package it.unisa.diem.oop.spazi;

/*ECCEZIONE CONTROLLATA -> estendiamo Exception*/
public class AccessibileException extends Exception {
    /*eccezione quando l'aula è piena e quando è vuota*/
    
    /**
     * Creates a new instance of <code>AccessibileException</code> without
     * detail message.
     */
    public AccessibileException() {
    }

    /**
     * Constructs an instance of <code>AccessibileException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AccessibileException(String msg) {
        super(msg);
    }
}
