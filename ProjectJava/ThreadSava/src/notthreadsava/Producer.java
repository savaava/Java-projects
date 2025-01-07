package notthreadsava;

import ausiliarie.Evento;

public class Producer implements Runnable{
    private final Buffer buffer;
   
    public Producer(Buffer buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run(){        
        while(! Thread.currentThread().isInterrupted()){
            Evento eToAdd = Evento.getEventoCasuale();
            
            synchronized(buffer){
                while(buffer.isFull()){
                    try{buffer.wait();        
                    }catch(InterruptedException ex){
                        System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                        return;
                    }
                }
                
                System.out.print("Thread "+Thread.currentThread().getName()+" produce: "+eToAdd);
                buffer.addEvento(eToAdd);
                System.out.println("Buffer corrente:\n"+buffer);
                buffer.notifyAll();
            }
            
            try{Thread.sleep(1000*1);         
            }catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return;
            }
        }
    }
}
