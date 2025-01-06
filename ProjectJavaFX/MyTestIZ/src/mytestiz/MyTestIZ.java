package mytestiz;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyTestIZ extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label();        
        TextField tfd = new TextField();
        Button btn = new Button();
        
        lbl.setText("label yee");
        btn.setText("Click me!");
        
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

//        btn.setOnAction((ActionEvent event) -> {
//            /* possiamo accedere solo in lettura a lbl */
//            lbl.setText(tfd.getText());
//            
//            /* la handle ha come parametro l'evento */
//            System.out.println("evento: "+event);
//        });
        
        lbl.textProperty().bind(tfd.textProperty());
        
        VBox root = new VBox(); /* Vbox è un nodo
        con un unico parametro possiamo gestire la spaziatura */
        //root.getChildren().add(btn);
        root.getChildren().addAll(lbl,tfd,btn);
        
        root.setAlignment(Pos.CENTER); /* allineato verticalmente e orizzontalmente */
        root.setPadding(new Insets(30));
        root.setSpacing(10);
        
        /* root è il contenitore -> finestra 300x250 */
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("My Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
