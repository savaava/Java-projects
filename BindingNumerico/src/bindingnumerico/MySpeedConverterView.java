package bindingnumerico;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MySpeedConverterView extends HBox {
    /* è un nodo che racchiude tutta la parte del grafo sotto
    ulteriore stratificazione (la nostra view specializzazione HBox)
    il controllo deve avere la possibilità di usare attributi
    set degli attributi quelli che sono gli oggetti che devono essere letti o aggiornati dal controller */
    public TextField input; /* anche protected o di default in base al package in base a lvl di compplessita */
    public Label display;
    
    public MySpeedConverterView(){
        super();
        initComponents(); /* si potrebbe mettere anche il codice nel costruttore */
    }
    
    private void initComponents(){
        input = new TextField();
        input.setPrefColumnCount(5);
        
        display = new Label();
        
        /* variabile locale perchè il controller non dovrà modificarla */
        Label symbol = new Label();
        
        symbol.setText("km/h --> kts");
        
        
        this.getChildren().addAll(input,symbol,display);
        
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.setSpacing(15); 
        
        this.setStyle("-fx-font: 16 Sans;");
    }
}
