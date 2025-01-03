package producerconsumer.ThreadSafe;

import java.util.Random;

public class Producer implements Runnable{
    private final Buffer<String> buffer;
    private final int delay;    
    
    public Producer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay;
    }
    
    @Override
    public void run() {
        Random p = new Random(2300);
        
        while(! Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(delay*1000);
                buffer.add("Info prodotto: "+p.nextInt(10));
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            System.out.println(Thread.currentThread().getName()+" ha aggiunto al buffer");
        }
    }        
}
