package producerconsumer.ThreadSafe2;

public class TestThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        Buffer<String> buffer = new Buffer<>(3);
        Producer prod = new Producer(buffer, 2);
        Consumer cons1 = new Consumer(buffer, 3);
        Consumer cons2 = new Consumer(buffer, 4);
        
        Thread tProd  = new Thread(prod);
        Thread tCons1 = new Thread(cons1);
        Thread tCons2 = new Thread(cons2);
        
        tProd.start();
        tCons1.start();
        tCons2.start();
        
        Thread.sleep(20*1000);
        
        tProd.interrupt();
        tCons1.interrupt();
        tCons2.interrupt();
    }
}
