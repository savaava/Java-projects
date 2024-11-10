package prove;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Prove extends Application {    
    @Override
    public void start(Stage primaryStage) {
        ProveView view = new ProveView();
        //new ProveController(view);
        
        Scene scene = new Scene(view, 500, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
