package contocorrenteiz;

public class Main {
    public static void main(String[] args) throws InterruptedException {        
        ContoCorrente c = new ContoCorrente(1000);
        
        Thread t1 = new Thread(new GuadagnaGuadagna(c));
        Thread t2 = new Thread(new SpendiSpendi(c)); /* risorsa condivisa */
        /* associamogli dei nomi: */
        t1.setName("guadagna guadagna");
        t2.setName("spendi spendi");
        
        /* partiranno insieme */
        t1.start();
        t2.start();
        
        Thread.sleep(15000); /* aspetto sul thread principale 15sec */
        
        t1.interrupt();
        t2.interrupt();
        
        /* regolamentare l'accesso tramite la risorsa metodo 1 */
    }
}
