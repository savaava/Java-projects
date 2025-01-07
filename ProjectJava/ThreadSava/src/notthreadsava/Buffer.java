package notthreadsava;

import ausiliarie.Evento;
import java.util.List;
import java.util.ArrayList;

public class Buffer {
    private final List<Evento> buffer;
    
    public Buffer(){
        buffer = new ArrayList<>();
    }
    
    public void addEvento(Evento e){
        buffer.add(e);
    }    
    public Evento removeEvento(int index){
        return buffer.remove(index);
    }
    
    public int numEventi(){
        return buffer.size();
    }
    public boolean isFull(){
        return buffer.size()==10;
    }
    public boolean isEmpty(){
        return buffer.isEmpty();
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        buffer.forEach(e -> strb.append(buffer.indexOf(e)+1).append(") ").append(e));
        
        return strb.toString();
    }
}
