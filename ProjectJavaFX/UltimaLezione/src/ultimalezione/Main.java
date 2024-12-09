package ultimalezione;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
        /*
        thread ausiliari che non interferiscono con eleenti grafici
        😊
        thread ausiliari per gestire operazioni per gestire un certo tempo o 
        per servizi esterni.
        prerogativa di gestire task che richiedono tempo 
        interfaccia interattiva gestita da thread buona pratica task di background
        interfaccia pur mantenendo la sua interattività risolve i task in background
        in questo modo non si blocca 
        javafx.concurrent gestisce direttamente 
        2 classi Task e Service: implementano Worker -> consente di implementare un dialogo
        tra il trhead principale e thread secondari. Utilizzare il dato quanod è disponibile
        che significa avere degli eventi che ci notificano.
        Una volta istanziato e ha eseguito il suo operato deve essere reistanziato.
        Task per implementare la logica dilavoro che deve essere seguito in background
        dobbiamo estendere Task oltre ha un tipo parametro e ha callable e non runnable quindi 
        esegue proprio una funzione sul thread secondario -> anzichè run abbiamo call che invece
        restituisce il tipo parametro 
        updateProgress passiamo lo stato di avanzamento del task del lavoro notifichiamo il thread 
        principale in cui si modificherà una proprietà e questo migliora l'informazione dello stato
        di avanzamento, ma anche un messaggio oltre al numero, quindi una stringa che mi da 
        un'informazione dello stato di avanzamento
        
        Task one-time -> dobbiamo sempre reinstanziare il task ogni volta.
        
        Service: per eseguir eun oggetto task su uno o più background
        Per istanziare un servizio dobbiamo 
        runningProperty per vedere se è in esecuzione (binding con questo per mostrare
        lo stato di avanzamento ) valueProperty potrebbe contenere una stringa corrente di ogni +
        iterazione se ho usato 
        u.openStream è il nostro componente concreto da cui possiamo fare la catena 
        il servizio può restituire qualsiasi cosa
        binding della valueProperty e textProperty del servizio -> return result ritorna il valore 
        e ritorna il tipo parametrizzto 
        valueProperty cntiene effetivamente il risultato progressivo (non esempio foto)
        all'interno della call un ciclo predeterminato che ad ogni iterazione produce
        un valore temporaneo updateValue ad ogni iterazione la valueProperty restituisce proprio
        il tipo parametrizzato, quindi vogliamo catturare
        altri metodi belli: task per vedere se è stato cancellato isCancelled()
        con il servizio abbiamo altri metodi come setOnCancelled con funzione lamba per dire cosa
        deve fare se è cancellato
        
        
        le collezioni se le aggiorno potrei non vedere il cambiamento 
        liste osservabili automatico, no con le liste normali
        
        
        servizi schedulati -> ogni 5 minuti mi devi avviare questo servizio:
        servizi di background mostrare periodicamente una finestrina
        */
    }
}
