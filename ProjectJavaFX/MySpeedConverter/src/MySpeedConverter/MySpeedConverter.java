package MySpeedConverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class MySpeedConverter extends Application {
    @Override
    public void start(Stage primaryStage) {        
//        /* interfaccia */
//        TextField tfd = new TextField();
//        tfd.setPrefColumnCount(5);
//        
//        Label display = new Label();
//        
//        Label symbol = new Label();
//        
//        symbol.setText("km/h --> kts");
//        
//        HBox root = new HBox();
//        root.getChildren().addAll(tfd,symbol,display);
//        
//        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(30));
//        root.setSpacing(15); 
//        
//        root.setStyle("-fx-font: 16 Sans;");
//        
//        /* Bindings contiene le espressioni matematiche e altre statiche per fare binding
//        bindBidirectional -> legare una proprietà di tipo stringa con una proprietà in un'altra forma
//        se cambia la proprietà numerica da destra, a
//        StringConverter<T> per convertire la proprietà di testo in proprietà che sta a destra
//        posso fare double property e poi lo string converter deve trasformare stringa in double property 
//        
//        public abstract class StringConverter<T> {
//        2 metodi
//        IntegerStringConverter, ... alcuni esistono già 
//        */
//        //Bindings.bindBidirectional(stringProperty, otherProperty, converter);
//        
//        /* questa è la prprietà che vogliamo mettere in relazione con il campo di text field string */
//        DoubleProperty input = new SimpleDoubleProperty();
//        
//        /* il convertitore doublestringconverter lo fa in entrambe le direzioni */
//        StringConverter sc = new DoubleStringConverter();
//        
//        /* tradurre il campo di testo in un binding numerico con sc  */
//        /* binding nunmerico convertito in proprietà di testo con sc (anche se non usato mo) */
//        Bindings.bindBidirectional(tfd.textProperty(), input, sc);
//        /* modificando il valore di tipo srtringa allora verrà invocato sc e lo converte */
//        
//        NumberBinding result = input.divide(1.852);
//        /* il risultato è un binding numerico allora dobbiamo fare un ulteriore conversione perchè
//        non è una stringa, nel caso dei binding numerici io posso sempre rappresentarli come stringhe con: */
//        display.textProperty().bind(result.asString("%.2f"));
        
        
        
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
