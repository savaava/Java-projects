package mytestiz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyTestIZ extends Application {
    @Override
    public void start(Stage primaryStage) {
        /* voglio aggiungere una label e un campo di testo e poi binding */
        Label lbl = new Label();
        /* ci sono varie implementazioni, devo imporatre il componente giusto: javafx.stage.Stage; */
        lbl.setText("label yee");
        
        TextField tfd = new TextField();
        /* ora per renderli visibili li devo aggiungere al group quindi riga 69 */
        
        Button btn = new Button();
        btn.setText("Click me!");
        /* il parametro del metodo è l'implementazione dell'interfaccia EventHandler che cattura l'evento 
        ha senso fare la classe anonima, per passare una funzione a un metodo faccio così questo è il vantaggio
        della classe anonima */
//        btn.setOnAction(new EventHandler<ActionEvent>() {            
//            @Override
//            public void handle(ActionEvent event) {
//                /* possiamo accedere solo in lettura a lbl */
//                lbl.setText(tfd.getText());
//                
//                /* la handle ha come parametro l'evento */
//                System.out.println("evento: "+event);
//            }
//        });
        /* lambda expression per sintetizzare ancora di più mettendo solo quello che mi serve effettivamente:
        mi serve solo il corpo di handle e ActionEvent event. Se ci sono più metodi non possiamo fare lamba
        1 unico metodo (solo per le interfacce funzionali con un unico metodo) -> usa lambda e 
        accorpa solo la sintassi utile    si potrebbe usare addirittura solo (e -> {...}); */
        btn.setOnAction((ActionEvent event) -> {
            /* possiamo accedere solo in lettura a lbl */
            lbl.setText(tfd.getText());
            
            /* la handle ha come parametro l'evento */
            System.out.println("evento: "+event);
        });
        
        /* text propert */
        lbl.textProperty().bind(tfd.textProperty());
        
        /* per la root si usa il componente stackPane -> raccoglie gli elementi grafici
        e li mette uno dietro l'altro, in questo caso contiene solo un bottone */
        VBox root = new VBox(); /* Vbox è un nodo
        con un unico parametro possiamo gestire la spaziatura */
        //root.getChildren().add(btn);
        root.getChildren().addAll(lbl,tfd,btn);
        /* col metodo getChildren parto da root  */
        
        root.setAlignment(Pos.CENTER); /* allineato verticalmente e orizzontalmente */
        root.setPadding(new Insets(30)); /* il padding deve essere 30 top bottom left right */
        root.setSpacing(10);
        
        /* root è il contenitore -> finestra 300x250 */
        Scene scene = new Scene(root, 300, 250);
        /* sullo stage posso impostare un titolo, associargli una scena passandogli il riferimento dell
        oggetto scena */
        primaryStage.setTitle("My First Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
