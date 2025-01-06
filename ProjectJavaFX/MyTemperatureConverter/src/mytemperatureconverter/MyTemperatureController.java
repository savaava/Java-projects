package mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class MyTemperatureController {
    private final MyTemperatureView view;
    
    public MyTemperatureController(MyTemperatureView view){
        this.view = view;
        initController();
    }
    
    private void initController(){
        DoubleProperty dp = new SimpleDoubleProperty();
        StringConverter sc = new DoubleStringConverter();
        
        Bindings.bindBidirectional(view.tfd.textProperty(), dp, sc);
        NumberBinding n1 = dp.multiply(1.8F).add(32);
        NumberBinding n2 = dp.subtract(32).multiply(5.0/9.0);
        NumberBinding n = Bindings.when(view.boxTF.selectedProperty()).then(n1).otherwise(n2);
        StringBinding str = Bindings.when(view.boxTF.selectedProperty()).then("Fahr to Celsius").otherwise("Celsius to Fahr");
        
        view.lblDirection.textProperty().bind(str);
        view.lblResult.textProperty().bind(n.asString("%.4f"));
    }
}
