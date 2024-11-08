/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myinputconfirm;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyInputConfirm extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label lbl1 = new Label();
        Label lbl2 = new Label();
        TextField tfd1 = new TextField();
        TextField tfd2 = new TextField();
        Button btn = new Button();
        
        lbl1.setText("input: ");
        lbl2.setText("Confirm input: ");
        
        btn.setText("OK");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("E' stato premuto il button!");                
            }
        });
        
        BooleanBinding ex = Bindings.or(tfd1.textProperty().isEmpty(), tfd1.textProperty().isNotEqualTo(tfd2.textProperty()));
        btn.disableProperty().bind(ex);

        GridPane root = new GridPane();        
        root.add(lbl1,0,0); // column=0 row=0
        root.add(lbl2,0,1);
        root.add(tfd1,1,0);
        root.add(tfd2,1,1);
        root.add(btn,1,2);
            
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("MyInputConfirm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
