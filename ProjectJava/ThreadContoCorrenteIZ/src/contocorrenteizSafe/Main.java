package contocorrenteizSafe;

public class Main {
    public static void main(String[] args) throws InterruptedException {        
        /* risorsa condivisa */
        ContoCorrente c = new ContoCorrente(1000);
        
        Thread t1 = new Thread(new GuadagnaGuadagna(c));
        Thread t2 = new Thread(new SpendiSpendi(c));

        /* associare dei nomi ai thread: */
        t1.setName("guadagna guadagna");
        t2.setName("spendi spendi");
        
        /* thread partono in maniera concorrente (parallelismo simulato) */
        t1.start();
        t2.start();
        
        /* aspetto sul thread principale 15sec */
        Thread.sleep(15000);

        t1.interrupt();
        t2.interrupt();
    }
}
