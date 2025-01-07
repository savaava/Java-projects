package notthreadsava;

public class TestThreadSava {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        Thread p = new Thread(new Producer(b));
        Thread c = new Thread(new Consumer(b));
        
        p.setName("PRODUTTORE");
        c.setName("CONSUMATORE");
        
        p.start();
        c.start();
        
        try{Thread.sleep(1000*30);
        }catch(InterruptedException ex){}
        
        p.interrupt();
        c.interrupt();
    }
}
