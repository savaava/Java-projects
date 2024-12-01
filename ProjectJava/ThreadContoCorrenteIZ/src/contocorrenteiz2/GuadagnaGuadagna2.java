package contocorrenteiz2;

import java.util.Random;

public class GuadagnaGuadagna2 implements Runnable{
    private final ContoCorrente2 c;    
    
    public GuadagnaGuadagna2(ContoCorrente2 c){
        this.c = c;
    }
    
    @Override
    public void run() {
        Random n = new Random(23400);
        
        while(! Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                return;
            }
            
            synchronized(c){
                double versamento = (n.nextInt(19)+1)*50;
                c.versa(versamento);
                System.out.println(Thread.currentThread().getName()
                        +" ha versato: "+versamento
                        +" nuovo saldo: "+c.getSaldo());
            }
            
        }
    }    
}
