package oop2019.prova.gruppo77;

import java.util.Random;

public abstract class NetworkDevice implements NetworkInterface {
    private final int address;
    private NetworkInterface connection;
    
    public NetworkDevice(){
        address = new Random().nextInt();
        connection = null;
    }
    
    public int getAddress(){
        return address;
    }
    public NetworkInterface getConnection(){
        return connection;
    }
    
    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message){
        if(destAddress != address)
            return ;
        
        process(sourceAddress, message);
    }
    
    @Override
    public void connect(NetworkInterface other){
        connection = other;
    }
    
    public abstract void process(int sourceAddress, String message);   
    
    @Override
    public int hashCode(){
        return Integer.hashCode(address);
    }
    
    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(other.getClass() != this.getClass())
            return false;
        
        NetworkDevice o = (NetworkDevice)other;
        return (o.address == address);
    }
    
    @Override
    public String toString(){
        return "Device "+address;
    }
}
