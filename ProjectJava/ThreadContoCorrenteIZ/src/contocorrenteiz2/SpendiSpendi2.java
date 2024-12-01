package contocorrenteiz2;

import java.util.Random;

public class SpendiSpendi2 implements Runnable{
    private final ContoCorrente2 c;

    public SpendiSpendi2(ContoCorrente2 c) {
        this.c = c;
    }
    
    @Override
    public void run() {
        Random n = new Random(23400);
        
        while(! Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                return ;
            }
            
            synchronized(c){
                double prelievo = (n.nextInt(19)+1)*50;
                c.preleva(prelievo);
                System.out.println(Thread.currentThread().getName()
                        +" ha prelevato: "+prelievo
                        +" nuovo saldo: "+c.getSaldo());
            }
            
        }
    }
}
