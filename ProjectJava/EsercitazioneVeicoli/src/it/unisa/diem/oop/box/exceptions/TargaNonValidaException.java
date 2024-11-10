package it.unisa.diem.oop.box.exceptions;

import it.unisa.diem.oop.box.exceptions.BoxException;

public class TargaNonValidaException extends BoxException {
    public TargaNonValidaException() {}
    public TargaNonValidaException(String msg) {
        super(msg);
    }
}
