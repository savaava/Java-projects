package producerconsumer.ThreadSafe;

public class Consumer implements Runnable{
    private final Buffer<String> buffer;
    private final int delay;    
    
    public Consumer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        while(! Thread.currentThread().isInterrupted()){
            String element;
            try {
                Thread.sleep(delay*1000);
                element = buffer.remove();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            System.out.println(Thread.currentThread().getName()+" ha letto dal buffer: "+element);
        }        
    }
}
