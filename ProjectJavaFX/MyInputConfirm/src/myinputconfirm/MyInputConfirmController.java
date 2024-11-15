package myinputconfirm;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableBooleanValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MyInputConfirmController {
    private final MyInputConfirmView view;
    
    public MyInputConfirmController(MyInputConfirmView view){
        this.view = view;
        initController();
    }
    
    private void initController(){
        BooleanBinding op1 = view.tfd1.textProperty().isEmpty();
        BooleanBinding op2 = view.tfd1.textProperty().isNotEqualTo(view.tfd2.textProperty());
        //BooleanBinding observ = Bindings.or(op1, op2);
        BooleanBinding observ = op1.or(op2);
        view.btn.disableProperty().bind(observ);
        
//        view.btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                buttonAction();
//            }
//        });
        
        view.btn.setOnAction((ActionEvent event) -> {
            buttonAction();
        });
    }
    
    private void buttonAction(){
        System.out.println("E' stato premuto il button!");
    }
}
