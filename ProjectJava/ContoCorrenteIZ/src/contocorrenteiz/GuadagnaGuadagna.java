package contocorrenteiz;

import java.util.Random;

/* questo è il thread che mette i soldi sul conto */
public class GuadagnaGuadagna implements Runnable{
    private final ContoCorrente c;    
    
    public GuadagnaGuadagna(ContoCorrente c){
        this.c = c;
    }
    
    @Override
    public void run() {
        /* voglio simulare un utente che mette i soldi sul conto con una certa cadenza 
        per poter arrestare un thread è interromperlo dal thread principale tramite il thread principale
        con il metodo currentThread(): ci sono delle caratteristiche isInterrupted() se c'è stata una 
        richiesta d'interruzione: */
        /* quindi recuperismo  */
        
        Random n = new Random(23400);
        
        while(! Thread.currentThread().isInterrupted()) {
            /* isInterrupted non viene messo a true se è messo a riposo però se è a riposo allora solleva l'eccezione
            dal thread principale, per interroperlo in maniera deliberata*/
            try {
                /* metodo della classe Thread: sleep -> il thread sta in attesa controllata per un tempo: */
                Thread.sleep(3000); /* la sospensione per 3 secondi avviene al thread che l'ha invocato */
            } catch (InterruptedException ex) {
                return ; /*arrestiamo il thread*/
            }
            
//            /* voglio che periodicamente vengano versati almeno 50 euri */
//            double versamento = (n.nextInt(19)+1)*50;
//            c.versa(versamento); /* il mutex viene rilasciato subito dopo questo e quindi l'altro thread può accedere a c */
//            //è possibile associare ai thread un nome: setName per indentificare il thread
//            System.out.println(Thread.currentThread().getName()+" ha versato: "+versamento+" nuovo saldo: "+c.getSaldo());
//            /* il problema sta nella stampa: getSaldo dopo il prelievo 
//            la risorsa è consistente ma la stampa no perchè dopo c.versa() rilascia il mutex e l'altro thread esegue preleva
//            quindi conviene gestsire il problema della sincornizzazione dal lato del thread, quindi ora proviamo lìil secondo metodo
//            quindi il rilascio del mutex lo faremo dopo la stampa  */
            
            
            synchronized(c){ /* quindi mettiamo questo però naturalmente ora non servono più quei syncronized
                dentro alla classe ContoCorrente 
                serve ad esempio quando viene fornito un codice una risorsa da utilizzare già stabilito
                e quindi gestiamo la sincronizzazione tramite i singoli thread, però potrebbe convenire
                usare la sincronizzazione sul contocorrente quando non vogliamo mettere syncronized su 
                ogni thread */
                double versamento = (n.nextInt(19)+1)*50;
                c.versa(versamento);
                System.out.println(Thread.currentThread().getName()+" ha versato: "+versamento+" nuovo saldo: "+c.getSaldo());
            }
        }
    }    
}
