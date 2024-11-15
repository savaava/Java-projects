package mytemperatureconverter;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyTemperatureView extends VBox {
    protected Label lblDirection;
    protected TextField tfd;
    protected Label lblResult;
    protected CheckBox boxTF;
    
    public MyTemperatureView(){
        super();
        initView();
    }
    
    private void initView(){
        lblDirection = new Label();
        tfd = new TextField();
        lblResult = new Label();
        boxTF = new CheckBox();
        
        Label lblIn = new Label("Input: ");
        Label res = new Label("Result: ");
        Label lblFrecce = new Label("<--->");
        
        HBox row2 = new HBox(lblIn,tfd);
        row2.setAlignment(Pos.CENTER);
        row2.setSpacing(6);
        
        HBox row3 = new HBox(res,lblResult);
        row3.setAlignment(Pos.CENTER);
        row3.setSpacing(6);
        
        HBox row4 = new HBox(boxTF,lblFrecce);
        row4.setAlignment(Pos.CENTER);
        row2.setSpacing(6);
        
        this.getChildren().addAll(lblDirection, row2, row3, row4);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
    }
}
