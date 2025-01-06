package myinputconfirm;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;

public class MyInputConfirmController {
    MyInputConfirmView view;
    
    public MyInputConfirmController(MyInputConfirmView view){
        this.view = view;
        init();
    }
    
    private void init(){
        view.btn.setOnAction(e -> System.out.println("btn clicked"));
        
        BooleanBinding cond1 = view.tfd2.textProperty().isEmpty();
        BooleanBinding cond2 = view.tfd1.textProperty().isNotEqualTo(view.tfd2.textProperty());
        view.btn.disableProperty().bind(Bindings.or(cond1,cond2));
    }
}
