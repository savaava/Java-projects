package provaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProvaIO {
    public static void main(String[] args) throws IOException {
        ObservableList<String> lista1 = FXCollections.observableArrayList();
        ObservableList<Integer> lista2 = FXCollections.observableArrayList();
        lista1.addAll("ciao","okok","wewewe");
        lista2.addAll(1,223,543,8);
        
        System.out.println(lista1+"\n"+lista2);
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Data.bin")))){
            oos.writeObject(new ArrayList<>(lista1));
            oos.writeObject(new ArrayList<Integer>(lista2));
        }
        
        
        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Data.bin")))){
            try {
                lista1.setAll((Collection<String>)ois.readObject());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }        
        System.out.println(lista1+"\n"+lista2);
        
        new File("Data.bin").delete();
    }
}
