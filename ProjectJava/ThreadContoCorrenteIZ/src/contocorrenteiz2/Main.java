package contocorrenteiz2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ContoCorrente2 c = new ContoCorrente2(1000);
        
        Thread t1 = new Thread(new GuadagnaGuadagna2(c));
        Thread t2 = new Thread(new SpendiSpendi2(c));
        
        t1.setName("guadagna guadagna");
        t2.setName("spendi spendi");
        
        t1.start();
        t2.start();
        
        Thread.sleep(15000);
        
        t1.interrupt();
        t2.interrupt();
    }
}
