package ultimalezione;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        /* restituiamo  */
        return new Task<String>() {
            @Override
            protected String call() throws Exception { /* facendo throws Exception non capiamo 
                l'errore nel thread e sarebbe importante catturare l'eccezione e mostrarla */
                
               /* posso gestire quello che mi serve per l'esecuzione del task */
               String msg = "";
               
               /* i=1 perchè il metodo updateProgress parte da 1 */
               for(int i=1; i<=10; i++){
                   msg = "iteration: "+i;
                   updateProgress(i,10); /* sono all'terazione i delle 10 totali */
                   updateValue(msg); /* ad ogni iterazione mettiamo un nuovo messaggio */
                   Thread.sleep(500);
               }               
               return msg;
            }            
        };
    }    
}
