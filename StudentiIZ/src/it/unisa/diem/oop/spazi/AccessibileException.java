package it.unisa.diem.oop.spazi;

/* ECCEZIONE CONTROLLATA --> estendiamo Exception */
public class AccessibileException extends Exception {
    public AccessibileException() {}
    public AccessibileException(String msg) {
        super(msg);
    }
}
