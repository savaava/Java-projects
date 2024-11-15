package mytemperatureconverter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyTemperatureConverter extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyTemperatureView view = new MyTemperatureView();        
        new MyTemperatureController(view);
        
        Scene scene = new Scene(view, 300, 250);

        primaryStage.setTitle("My Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
