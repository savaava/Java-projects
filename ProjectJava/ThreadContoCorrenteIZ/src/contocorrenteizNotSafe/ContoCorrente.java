package contocorrenteizNotSafe;

public class ContoCorrente {
    private double saldo;
    
    public ContoCorrente(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void versa(double importo) {
        if(importo <= 0) throw new RuntimeException("Non è possibile versare l'importo: "+importo);
        saldo+=importo;
    }
    
    public void preleva(double importo){
        if(importo <= 0 || importo > saldo) 
            throw new RuntimeException("Non è possibile prelevare importo: "+importo);
        saldo-=importo;
    }
}
