package mystudentlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MyStudentListViewController implements Initializable {
    @FXML
    private TextField nameField, surnameField, codeField;
    @FXML
    private Button addButton, delButton;
    @FXML
    private TableView<Student> studentTable; /* la table view ha bisogno di una lista, solo una lista osservabile */
    @FXML
    private TableColumn<Student, String> nameClm, surnameClm, codeClm;
    
    private ObservableList<Student> students;
    
    private FileChooser fileChooserSave, fileChooserRead;
    
    /* controller implementa inizializzabile -> non gestendo un controller con un costruttore
    avviando l'applicazione potrei avere la necessità di istanziare cose quindi le cose che devo
    fare una sola volta all'avvio dell'applicazione lo mettiamo in initialize */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        students = FXCollections.observableArrayList();
        /* lista osservabile di studenti ora la connesione tra la table view e la lista
        table view ha setItems e itemproperty, connessione: */
        studentTable.setItems(students);
        
        /* 1° metodo */
        nameClm.setCellValueFactory(s -> {
            /* s è un riferimento di celldatfeatures */
            //s.getValue().getName(); /* mi restituisce un tipo studente */
            /* lui però vuole una stringa osservabile quindi una string property */
            return new SimpleStringProperty(s.getValue().getName());
        });
        
        /* la seconda colonna usiamo la classe aiutante: 
        vede all'interno della classe student  */
        surnameClm.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        codeClm.setCellValueFactory(new PropertyValueFactory<>("code"));
        /* qui è importante la convenzione perchè se non la chiamavamo getCognome, get... allora
        non funzionava */
        
        BooleanBinding op1 = nameField.textProperty().isEmpty();
        BooleanBinding op2 = surnameField.textProperty().isEmpty();
        BooleanBinding op3 = codeField.textProperty().isEmpty();
        BooleanBinding pippoCond = op1.or(op2).or(op3);
        addButton.disableProperty().bind(pippoCond);
        
        
        
        fileChooserSave = new FileChooser();
        fileChooserSave.setTitle("Save csv file");
        fileChooserSave.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
        
        fileChooserRead = new FileChooser();
        fileChooserRead.setTitle("Open Resource File");
        fileChooserRead.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
//        fileChooserRead.getExtensionFilters().addAll(
//        new ExtensionFilter("Text Files", "*.txt"),
//        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//        new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//        new ExtensionFilter("All Files", "*.*"));


        nameClm.setCellFactory(TextFieldTableCell.forTableColumn());
        /* però questo mi permetto solo di modificare i textfield
        quindi per modificare effettivamente si deve usare una cattura di evento 
        quindi da fxml scenebuilder mettere sulle colonne che voglio in code
        oltre all'id anche i metodi che si invocano quando avvengono queste 3 cose:
        OnEditStart, OnEditCommit, OnEditCancel e chiammo ad esempio updateName
        */
    }    

    @FXML
    private void addStudent(ActionEvent event) {
        students.add(new Student(nameField.getText(), surnameField.getText(), codeField.getText()));
    }

    @FXML
    private void delStudent(ActionEvent event) {
    }
    
    @FXML
    private void updateName(TableColumn.CellEditEvent<Student, String> event) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        s.setName(event.getNewValue());
    }
    
    @FXML
    private void saveCSV() throws IOException {
        System.out.println("*****Scrittura CSV iniziata*****");
        
        Stage stage = MyStudentList.getStage();
        File fileSaved = fileChooserSave.showSaveDialog(stage);
        /* se passiamo null allora la finestra è svincolata dalla scena principale,
        potrei passare anche altri nodi del mio programma */
        if(fileSaved == null) return;
        
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileSaved)))){
            for(Student si : students){
                pw.append(si.getName()).append(";");
                pw.append(si.getSurname()).append(";");
                pw.append(si.getCode()).append("\n");
            }
                        
            System.out.println("*****Scrittura CSV completata*****");
        }
    }
    /* FORMATO file.csv:
    nome;cognome;codicefiscale\n
    nome;cognome;codicefiscale\n
    ...
    */
    
    @FXML
    private void readCSV() throws IOException {
        Stage stage = MyStudentList.getStage();
        File selectedFile = fileChooserRead.showOpenDialog(stage);
        if(selectedFile == null) return; /* se preme Annulla */
        System.out.println("file.csv selezionato: "+selectedFile.getAbsolutePath());
        
        System.out.println("*****Lettura CSV iniziata*****");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(selectedFile)))){
            s.useDelimiter("[;\n]");
            s.useLocale(Locale.ITALY); //anche se non dovrebbe servire a nulla
            
            while(s.hasNext()){
                String name = s.next();
                String surname = s.next();
                String code = s.next();
                students.add(new Student(name,surname,code));
            }
            
            System.out.println("*****Lettura CSV completata*****");
        }
    }
}
