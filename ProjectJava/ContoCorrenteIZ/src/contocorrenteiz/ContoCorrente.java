package contocorrenteiz;

/* è la risora condivisa */
public class ContoCorrente {
    private double saldo;
    
    public ContoCorrente(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo() {
        /* anche se è una fase di lettura è comunque importante sincronizzare */
        synchronized(this) {
            return saldo;
        }
        /* se è tutto il metodo che deve essere sincronizzato allora posso
        scrivere direttamente dopo public 
        syncronized con this perchè si riferisce alla risorsa c
        il primo thread che prende uno di questi metodi allora esegue e gli altri
        aspettano */
    }

    public synchronized void versa(double importo) {
        if(importo <= 0) throw new RuntimeException("Non è possibile versare l'importo: "+importo);
        saldo+=importo;
    }
    
    public synchronized void preleva(double importo){
        if(importo <= 0 || importo > saldo) 
            throw new RuntimeException("Non è possibile prelevare importo: "+importo);
        saldo-=importo;
        
        //System.out.println("Saldo: "+saldo);
    }
}
