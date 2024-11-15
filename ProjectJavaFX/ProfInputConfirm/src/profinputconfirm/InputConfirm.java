package profinputconfirm;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author leonardorundo
 */
public class InputConfirm extends Application {
    @Override
    public void start(Stage primaryStage) {        
        /* Inizio Versione con VBox */
        VBox root = new VBox();
        
        Label lbl1 = new Label();
        Label lbl2 = new Label();
        TextField tfd1 = new TextField();
        TextField tfd2 = new TextField();
        Button btn = new Button();
        
        lbl1.setText("Input:");
        lbl2.setText("Confirm input:");
        btn.setText("Ok");
        
        //row1 
        HBox row1 = new HBox();
        row1.getChildren().addAll(lbl1, tfd1);
        row1.setSpacing(10);
        row1.setAlignment(Pos.CENTER);
        
        //row2
        HBox row2 = new HBox();
        row2.getChildren().addAll(lbl2, tfd2);
        row2.setSpacing(10);
        row2.setAlignment(Pos.CENTER);
        
        //container 
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(row1,row2,btn);
        root.setSpacing(20); 
        
        /* Fine Versione con VBox */
                
        /* Inizio Versione con GridPane
        
        //row1
        Label lbl1 = new Label();
        lbl1.setText("Input:");
        TextField tfd1 = new TextField();
                
        //row2
        Label lbl2 = new Label();
        TextField tfd2 = new TextField();
        lbl2.setText("Confirm input:");     
        
        Button btn = new Button();
        btn.setText("Ok");
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        GridPane.setConstraints(lbl1, 0, 0);
        GridPane.setConstraints(tfd1, 1, 0);
        GridPane.setConstraints(lbl2, 0, 1);
        GridPane.setConstraints(tfd2, 1, 1);
        GridPane.setConstraints(btn, 1, 2);
        
        GridPane.setMargin(lbl1, new Insets(5));
        GridPane.setMargin(tfd1, new Insets(5));
        GridPane.setMargin(lbl2, new Insets(5));
        GridPane.setMargin(tfd2, new Insets(5));
        GridPane.setMargin(btn, new Insets(5));
        
        root.getChildren().addAll(lbl1,tfd1,lbl2,tfd2,btn);
        
        /* Fine Versione con GridPane */
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("InputConfirm");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
        //Bindings
        
        BooleanBinding ex = Bindings.or(tfd1.textProperty().isEmpty(), tfd1.textProperty().isNotEqualTo(tfd2.textProperty()));
        
        btn.disableProperty().bind(ex);
        
        //Azione al click sul bottone btn
        
        /* Versione con lambda expression */
        btn.setOnAction(event -> buttonAction());
        
        /* Versione con classe anonima
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                buttonAction();
            }
        });
        */
    }
    
    private void buttonAction() {        
        System.out.println("Cliccato!");
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
