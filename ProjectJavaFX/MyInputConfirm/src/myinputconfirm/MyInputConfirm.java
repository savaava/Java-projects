package myinputconfirm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyInputConfirm extends Application {    
    @Override
    public void start(Stage primaryStage) {        
        MyInputConfirmView view = new MyInputConfirmView();        
        new MyInputConfirmController(view);
        
        Scene scene = new Scene(view, 300, 250);
        
        primaryStage.setTitle("MyInputConfirm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }    
}
