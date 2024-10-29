package oop2019.prova.gruppo77;

public class Computer extends NetworkDevice {
    private final String name;
    
    public Computer(String name){
        //super();
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void remoteFileAccessRequest(int serverAddress, String fileName) throws NetworkException {
        if(getConnection() == null) throw new NetworkException("NetworkException");
        
        
    }
    
    public void remotePrintRequest(int printerAddress, String fileName) throws NetworkException {
        if(getConnection() == null) throw new NetworkException("NetworkException");
        
        
    }
    
    
    @Override
    public void process(int sourceAddress, String message) throws NetworkException {
        if(getConnection() == null) throw new NetworkException("NetworkException");        
        
        System.out.println(toString()+" ha ricevuto da "+sourceAddress+": Dati risposta: Accesso a "+message);
    }
    
    @Override
    public String toString(){
        return super.toString()+": Computer "+name;
    }
}
