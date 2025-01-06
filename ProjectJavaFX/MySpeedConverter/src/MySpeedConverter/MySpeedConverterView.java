package MySpeedConverter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MySpeedConverterView extends HBox {
    public TextField input;
    public Label display;
    
    public MySpeedConverterView(){
        initComponents();
    }
    
    private void initComponents(){
        input = new TextField();
        input.setPrefColumnCount(5);
        
        display = new Label();
        Label symbol = new Label("km/h --> kts");        
        
        this.getChildren().addAll(input,symbol,display);
        
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.setSpacing(15); 
        
        this.setStyle("-fx-font: 16 Sans;");
    }
}
