package mystudentlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStudentList extends Application {    
    private static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        usa il metodo load per ottenere dal file di testo che contiene la vista, istanzia gli oggetti
        grafici prendendo root come indirizzo 
        
        onAction="#handleButtonAction" il nome del metodo che eseguirà, nel controller avremo il metodo nel controller
        id -> l'attributo lo rendiamo accessibile al controller
        
        Label gli passiamo solo il riferimento al controller con id perchè magari nel controller scriveremo setText
        
        fx:controller="mystudentlist.MyStudentListViewController" qual è la classe controller che è destinata a gestire 
        gli elementi della vista: prende gli elementi grafici e si crea la corrispondenza all'
        interno del controller
        
        il file fxml dovrebbe stare nello stesso dei percorsi dei file .class ossia i file compilati ossia
        nella cartella bin, infatti fa la copia però poichè potrebbe non farlo provo a riavvira netbeans 
        altrimenti devo spostare il file fxml nella cartella dove ci sono class
        problema 2 eventuale: 
        */
        Parent root = FXMLLoader.load(getClass().getResource("MyStudentListView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("ciao");
        stage.setScene(scene);
        stage.show();
        
        primaryStage = stage;
    }
    
    public static Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
