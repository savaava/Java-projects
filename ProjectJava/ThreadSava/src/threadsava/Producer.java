package threadsava;

import ausiliarie.Evento;

public class Producer implements Runnable {
    private final Buffer buffer;
    
    public Producer(Buffer buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        while(! Thread.currentThread().isInterrupted()){
            Evento eToAdd = Evento.getEventoCasuale();
            buffer.addEvento(eToAdd);
            System.out.print("Thread "+Thread.currentThread().getName()+" produce "+eToAdd);
            System.out.println("Buffer corrente:\n"+buffer);           
            
            try{Thread.sleep(1000*1);}
            catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return;
            }
        }
    }
}
