package it.unisa.diem.oop.spazi.exceptions;

/* sottoclasse 1 di AccessException */
public class AulaVuotaException extends AccessibileException {
    public AulaVuotaException() {}
    public AulaVuotaException(String msg) {
        super(msg);
    }
}