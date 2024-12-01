package producerconsumer.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer<E> {
    /* se vogliamo rendere il buffer generico parametrizzando */
    private final int size;
    private final Queue<E> buffer;
    
    public Buffer(int size){
        this.size = size;
        this.buffer = new LinkedList<>();
    }
    
    /* se sono pubblici -> synchronized */
    public synchronized boolean isEmpty(){
        return buffer.isEmpty();
    }
    
    public synchronized boolean isFull(){
        return buffer.size()==size;
    }
    
    
    public synchronized void add(E e) throws InterruptedException{
        while(isFull()){
            wait(); /* questo obbliga il thread che ha invocato questo metodo ad aspettare un notifyAll */
        }
        buffer.add(e);
        notifyAll();
    }
    
    public synchronized E remove() throws InterruptedException{
        while(isEmpty()){
            wait();
        }
        notifyAll();
        return buffer.remove();
        /* finchè io non esco dal blocco io non rilascio il mutex quindi non mi preoccupo è thread-safe
        perchè notifyAll risveglia ma per far acquisire il mutex, questo thread deve per forza prima terminare
        questo blocco synchronized */
    }
}
