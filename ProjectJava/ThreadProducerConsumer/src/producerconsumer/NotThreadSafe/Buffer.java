package producerconsumer.NotThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer<E> {
    private final int size;
    private final Queue<E> buffer;
    
    public Buffer(int size){
        this.size = size;
        buffer = new LinkedList<>();
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return buffer.isEmpty();
    }
    
    public boolean isFull(){
        return buffer.size()>=size;
    }
    
    public void add(E e){ 
        buffer.add(e);
    }
    
    public E remove(){
        return buffer.remove();
    }
}
