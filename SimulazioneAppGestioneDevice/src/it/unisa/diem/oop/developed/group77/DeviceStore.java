package it.unisa.diem.oop.developed.group77;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import it.unisa.diem.oop.provided.*;

public class DeviceStore implements Filterable {
    private final String name;
    private Set<Device> store;
    
    /* relazione d'ordine numero 1 del TreeSet */
    public DeviceStore(String name){
        this.name = name;
        store = new TreeSet<>(); /* costruttore vuoto di TreeSet */
    }    
    
    /* relazione d'ordine numero 2 del TreeSet */
    public DeviceStore(String name, Comparator<Device> c){
        this.name = name;
        store = new TreeSet<>(c); /* costruttore di TreeSet che prende un comparatore */
    }
    
    public void addDevice(Device d){
        if(store.contains(d)) throw new DeviceInsertionException("Il dispositivo è già presente -> eccezione!!");
        store.add(d);
    }
    
    
    @Override
    public DeviceStore filter(DeviceFilter d, Comparator<Device> c){
        DeviceStore out;
        if(c == null)
            out = new DeviceStore(this.name);
        else
            out = new DeviceStore(this.name, c);
        
        for(Device di : store){
            if(d.checkDevice(di))
                out.store.add(di); /* aggiunge nell'ordine stabilito dal costruttore */
        }
        
        return out;
    }    
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer(name);
        strb.append(" contains ").append(store.size()).append(" items.\nPrinting:\n*****\n");
        for(Device di : store){
            strb.append(di).append("\n*****\n");
        }
        return strb.toString();
    }
}
