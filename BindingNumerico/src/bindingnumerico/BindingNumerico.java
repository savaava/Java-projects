package bindingnumerico;

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

public class BindingNumerico extends Application {
    @Override
    public void start(Stage primaryStage) {        
//        /* interfaccia */
//        TextField tfd = new TextField();
//        tfd.setPrefColumnCount(5);
//        /* limitare la larghezza del text field */
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
//        /* interfaccia pronta -> ora i comportamenti: */
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
        /*
        08_11
        come organizzare meglio il codice quando ci troviamo davanti ad applicazioni con interfacce
        grafiche, quindi parliamo di pattern con interfaccia grafica (FXml) la prossima volta
        a volte è più semplpice con codice rispetto a trascinamento ad esempio se devi trascinare 50 pulsanti
        è più difficile invece con un for e gridpain è più semplice
        
        abbiamo diviso il codice in due parti, ci vuole un'orgainazzzoine per manutenibilità e riuso anche
        per le classi -> spostare la parte relativa alla VISTA O GRAFICA viene organizzata separata dalla
        GESTIONE DEI COMPORTAMENTI (BUONA PRATICA DI PROGRAMMAZIONE) stessa cosa che abbiamo fatto qui però
        in questo caso siamo in una classe file java
        
        la vista della nostra applicazione è tutto quello che ho scritto tranne i comportamenti Bindings
        che è indipendente dai comportamenti (infatti senza i comportamenti comunque è funzionante l'app)
        un pattern nella progettazine di app con interfacce grafiche è appunto pattern model view control:
        3 entità: 
        1 modello (in questo caso è solo una conversione) (se hoo una lista di persone allora il controller interagisce
        con il modello prelevando i dati con il modello)
        2 vista 
        3 controller 
        Manutenibile, leggibile, riusabile
        */
        launch(args);
    }
}
