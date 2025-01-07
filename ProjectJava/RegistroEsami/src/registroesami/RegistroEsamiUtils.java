package registroesami;

import java.io.*;

public class RegistroEsamiUtils {
    public static RegistroEsami caricaDaFileBinario(String filename) {
        RegistroEsami out = new RegistroEsami();
        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            out = (RegistroEsami)ois.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("Eccezione in caricaDaFileBinario: \n");
            return null;
        }        
        return out;
    }
    
    public static boolean salvaSuFileBinario(String filename, RegistroEsami r) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            oos.writeObject(r);
        }catch(IOException ex){
            System.out.println("Eccezione in salvaSuFileBinario: \n");
            return false;
        }
        return true;
    }
}
