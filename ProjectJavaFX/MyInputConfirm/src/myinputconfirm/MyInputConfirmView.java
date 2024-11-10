package myinputconfirm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MyInputConfirmView extends GridPane {
    public Button btn;
    public TextField tfd1,tfd2;
    
    public MyInputConfirmView(){
        super();
        initView();
    }
    
    private void initView(){
        Label lbl1 = new Label("input: ");
        Label lbl2 = new Label("confirm input: ");               
        
        tfd1 = new TextField();
        tfd2 = new TextField();        
        btn = new Button("Ok");
        
        this.add(lbl1,0,0);
        this.add(lbl2,0,1);
        this.add(tfd1,1,0);
        this.add(tfd2,1,1);
        this.add(btn,1,2);
        
        this.setAlignment(Pos.CENTER);
    }
}
