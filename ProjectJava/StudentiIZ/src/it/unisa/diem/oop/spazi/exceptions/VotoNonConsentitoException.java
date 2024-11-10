package it.unisa.diem.oop.spazi.exceptions;

/*ECCEZIONE NON CONTROLLATA -> estendiamo RuntimeException*/
public class VotoNonConsentitoException extends RuntimeException {
    public VotoNonConsentitoException() {}
    
    public VotoNonConsentitoException(String msg) {      
        super(msg);
    }
}
