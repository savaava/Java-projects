package producerconsumer.NotThreadSafe;

public class Consumer implements Runnable {
    private final Buffer<String> buffer;
    private final int delay;    
    
    public Consumer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay;
    }
    
    @Override
    public void run(){
        String element;
        
        while(! Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(delay*1000);                    
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage()+"thread consumer interrotto");
                return;
            }           
            
            synchronized(buffer){
                while(buffer.isEmpty()){
                    try {
                        buffer.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage()+"thread consumer interrotto");
                        return;
                    }
                }

                element = buffer.remove();
                buffer.notifyAll();
            }
            System.out.println(Thread.currentThread().getName()+" ha letto dal buffer: "+element);
        }
    }
}
