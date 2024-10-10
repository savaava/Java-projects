package it.unisa.diem.oop.persone;

/*ECCEZIONE NON CONTROLLATA -> estendiamo RuntimeException*/
public class VotoNonConsentitoException extends RuntimeException {
/* deve sempre essere o una sottoclasse di exception o runtimeexception:
        decidiamo in base alla nostra esigenza*/
    public VotoNonConsentitoException() {}
    
    public VotoNonConsentitoException(String msg) {      
        super(msg);
    }
}
