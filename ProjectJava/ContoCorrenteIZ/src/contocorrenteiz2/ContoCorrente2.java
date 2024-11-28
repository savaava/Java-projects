package contocorrenteiz2;

public class ContoCorrente2 {
    private double saldo;
    
    public ContoCorrente2(double saldo){
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
