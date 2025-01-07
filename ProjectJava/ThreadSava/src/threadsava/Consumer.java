package threadsava;

public class Consumer implements Runnable {
    private final Buffer buffer;
    
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        while(! Thread.currentThread().isInterrupted()){
            buffer.rimuoviEvento((int)Math.round((buffer.numEventi()-1)*Math.random()));
            System.out.println("Thread CONSUMATORE consuma un evento");
            System.out.println("Buffer corrente:\n"+buffer);
            
            try{Thread.sleep(1000*2);}
            catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return;
            }
        }
    }
}
