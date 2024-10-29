package oop2019.prova.gruppo77;

import java.util.Set;

public class NetworkHub implements NetworkInterface {
    private final String id;
    //private final Set<NetworkInterface> connessioni;
    
    public NetworkHub(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void printConnections(){
        
    }
    
        
    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message){
        
    }
    
    @Override
    public void connect(NetworkInterface other){
        
    }
    
    @Override
    public int hashCode(){
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(other.getClass() != this.getClass())
            return false;
        
        NetworkHub otherHub = (NetworkHub)other;
        return otherHub.id.equalsIgnoreCase(id);
    }
    
    @Override
    public String toString(){
        
    }
}
