package producerconsumer.ThreadSafe2;

import java.util.Random;

public class Producer implements Runnable {
    private final Buffer<String> buffer;
    private final int delay;
    
    public Producer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        Random p = new Random(2300);
        String element;
        
        while(! Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(delay*1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage()+"thread producer interrotto");
                return;
            }
            
            element = "Info prodotto: "+p.nextInt(10);
            synchronized(buffer){
                while(buffer.isFull()){
                    try {
                        buffer.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage()+"thread producer interrotto");
                        return;
                    }
                }
                
                buffer.add(element);
                buffer.notifyAll();
            }
            System.out.println(Thread.currentThread().getName()+" ha aggiunto al buffer -> "+element);
        }
    }
}
