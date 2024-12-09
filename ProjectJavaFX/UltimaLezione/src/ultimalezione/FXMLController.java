package ultimalezione;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class FXMLController implements Initializable {

    @FXML
    private ProgressIndicator progInd;
    @FXML
    private Label lbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        
    }     
    
    @FXML
    public void onButtonClicked() {
        MyService service = new MyService(); 
        /* non è ancora partito */
        
        /* agganciamo l'indicatore di progresso: */
        progInd.progressProperty().bind(service.progressProperty());
        
        /*proprietà di visibilità e dello stato di avanzamento per dire che deve essere visibile
        solo quando il task è in esecuzione */
        progInd.visibleProperty().bind(service.runningProperty());
        
        lbl.textProperty().bind(service.valueProperty()); /* in questo serve updateValue */
        
        
        
        List<String> iterazioni = new ArrayList<>();
        /* provo la cattura di eventi (evento di comletamento del mio task ausiliario) */
        service.setOnSucceeded(e -> { /* event handler quindi o un'istanza di classe anonima o lamba expr */
            System.out.println(service.getValue()+"abbiamo finito zio");
            lbl.textProperty().unbind(); /* ora riaquisisco il controllo sulla label */
            lbl.setText("COMPLETATO"); /* dopo che ha assunto il compito di mostrare lo stato 
            di avanzamento adesso dice che ha finito */
            iterazioni.add(service.getValue());
        });
        //service.getValue(); 
        /* questo ha senso solo quando il servizio HA FINITO e poi possiamo prendere il suo valore*/
        
        // service.restart(); 
        
        service.start();
        
        /* dove finisce la stringa il risultato lo voglio mettere nella label: */             
    }
}


