package prove;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProveView extends GridPane {
    public ProveView(){
        super();
        initView2();
    }
    
    private void initView1(){
        /* ... extends HBox */
        Label lbl1 = new Label("input: ");
        Label lbl2 = new Label("confirm input: ");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        Button btn = new Button("Ok");
        
        VBox v1 = new VBox(lbl1,lbl2);
        VBox v2 = new VBox(t1,t2,btn);
        this.getChildren().addAll(v1,v2);
        
        this.setAlignment(Pos.CENTER);
    }
    
    private void initView2(){
        /* ... extends GridPane */
        Label lbl0 = new Label("doppia riga -> ");
        Label lbl1 = new Label("input: ");
        Label lbl2 = new Label("confirm input: ");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        Button btn = new Button("Ok");
        
        this.add(lbl0,0,0,1,2);
        this.add(lbl1,1,0);
        this.add(lbl2,1,1);
        this.add(t1,2,0);
        this.add(t2,2,1);
        this.add(btn,2,2);
        
        this.setAlignment(Pos.CENTER);
    }
}
