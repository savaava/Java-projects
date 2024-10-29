package oop2019.prova.gruppo77;

public class FileServer extends NetworkDevice {
    @Override
    public void process(int sourceAddress, String message) throws NetworkException {
        if(getConnection() == null) throw new NetworkException("NetworkException");
        
        System.out.println(toString()+": Su richiesta di "+sourceAddress+": Accesso a "+message);
    }
    
    @Override
    public String toString(){
        return super.toString()+": File Server";
    }
}
