package contocorrenteizNotSafe;

import java.util.Random;

public class SpendiSpendi implements Runnable{
    private final ContoCorrente c;

    public SpendiSpendi(ContoCorrente c) {
        this.c = c;
    }
    
    @Override
    public void run() {
        Random n = new Random(33330);
        
        while(! Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                return;
            }
            
            synchronized(c){
                double prelievo = (n.nextInt(19)+1)*50;
                c.preleva(prelievo);
                System.out.println(Thread.currentThread().getName()
                        +"   ha prelevato: "+prelievo
                        +", nuovo saldo: "+c.getSaldo());
            }
            
        }
    }
}