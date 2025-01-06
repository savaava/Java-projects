package myinputconfirm;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class MyInputConfirmView extends GridPane {
    TextField tfd1, tfd2;
    Button btn;
    
    public MyInputConfirmView(){
        init();
    }
    
    private void init(){
        tfd1 = new TextField();
        tfd2 = new TextField();
        btn = new Button("Ok");
        
        add(new Label("input: "),0,0);
        add(new Label("confirm input: "),0,1);
        add(tfd1,1,0);
        add(tfd2,1,1);
        add(btn,1,2);
        
        setAlignment(Pos.CENTER);
    }
}
