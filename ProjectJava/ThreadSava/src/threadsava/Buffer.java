package threadsava;

import ausiliarie.Evento;
import java.util.List;
import java.util.ArrayList;

public class Buffer {
    private final List<Evento> buffer;
    
    public Buffer(){
        buffer = new ArrayList<>();
    }
    
    public synchronized int numEventi(){
        this.notifyAll();
        return buffer.size();
    }
    
    public synchronized void addEvento(Evento e){
        while(buffer.size() == 10){
            try{this.wait();}
            catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return;
            }
        }
        buffer.add(e);
        this.notifyAll();
    }
    public synchronized Evento rimuoviEvento(int index){
        while(buffer.isEmpty()){
            System.out.println("ECCOMIIII");
            try{this.wait();}
            catch(InterruptedException ex){
                System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                return null;
            }
        }
        this.notifyAll();
        System.out.println("ECCOMIIII");
        return buffer.remove(index);
    }
    
    @Override
    public synchronized String toString(){
        StringBuffer strb = new StringBuffer();
        
        buffer.forEach(e -> strb.append(buffer.indexOf(e)+1).append(") ").append(e));
        
        return strb.toString();
    }
}
