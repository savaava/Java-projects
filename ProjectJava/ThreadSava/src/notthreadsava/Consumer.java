package notthreadsava;

import ausiliarie.Evento;

public class Consumer implements Runnable{
    private final Buffer buffer;
   
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        
        while(! Thread.currentThread().isInterrupted()){            
            synchronized(buffer){
                while(buffer.isEmpty()){
                    try{buffer.wait();        
                    }catch(InterruptedException ex){
                        System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                        return;
                    }
                }
                
                int index = (int)Math.round((buffer.numEventi()-1)*Math.random());
                System.out.println("Thread "+Thread.currentThread().getName()+" consuma l'evento numero "+(index+1));
                Evento eConsumato = buffer.removeEvento(index);
                System.out.println("Buffer corrente:\n"+buffer);
                buffer.notifyAll();
            }
            
            try{Thread.sleep(1000*2);         
            }catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return;
            }
        }
    }
}
