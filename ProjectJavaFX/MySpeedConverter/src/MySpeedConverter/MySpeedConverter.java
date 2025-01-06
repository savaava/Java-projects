package MySpeedConverter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MySpeedConverter extends Application {
    @Override
    public void start(Stage primaryStage) {        
        MySpeedConverterView view = new MySpeedConverterView();        
        new MySpeedConverterController(view);
        
        Scene scene = new Scene(view, 400, 200);

        primaryStage.setTitle("MySpeedConverter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
