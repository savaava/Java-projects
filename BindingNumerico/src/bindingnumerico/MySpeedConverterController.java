package bindingnumerico;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class MySpeedConverterController {
    /* gestisce i comportamenti, per definizione deve avere un riferimento alla view */
    private MySpeedConverterView view;
    
    public MySpeedConverterController(MySpeedConverterView view){
        this.view = view;
        
        initBindings();
    }
    
    private void initBindings(){
        DoubleProperty input = new SimpleDoubleProperty();
        
        StringConverter sc = new DoubleStringConverter();
        
        Bindings.bindBidirectional(view.input.textProperty(), input, sc);
        
        NumberBinding result = input.divide(1.852);
        
        view.display.textProperty().bind(result.asString("%.2f"));
    }
}
