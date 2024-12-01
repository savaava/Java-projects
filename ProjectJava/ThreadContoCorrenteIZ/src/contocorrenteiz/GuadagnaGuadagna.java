package contocorrenteiz;

import java.util.Random;

/* questo è il thread che mette i soldi sul conto */
public class GuadagnaGuadagna implements Runnable{
    private final ContoCorrente c;    
    
    public GuadagnaGuadagna(ContoCorrente c){
        this.c = c;
    }
    
    @Override
    public void run() {      
        Random n = new Random(23400);
        
        while(! Thread.currentThread().isInterrupted()) {
            /* isInterrupted non viene messo a true se è messo a riposo però se è a riposo allora solleva l'eccezione
            dal thread principale, per interroperlo in maniera deliberata*/
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                return;
            }
             
            /* voglio che periodicamente vengano versati almeno 50 euri */
            double versamento = (n.nextInt(19)+1)*50;
            c.versa(versamento);
            System.out.println(Thread.currentThread().getName()
                    +" ha versato: "+versamento
                    +" nuovo saldo: "+c.getSaldo());
        }
    }    
}
