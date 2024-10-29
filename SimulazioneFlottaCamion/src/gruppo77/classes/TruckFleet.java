package gruppo77.classes;

import gruppo77.interfaces.Filterable;
import gruppo77.exception.NotValidChassisIDException;
import gruppo77.interfaces.TruckFilter;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class TruckFleet implements Filterable {
    private final String name;
    private final List<Truck> fleet; 
    /* Scelta l'interfaccia List perche permette duplicati e poi si può ordinare 
       usando il metodo sort ereditato da List che usa un oggetto comparatore */
    
    public TruckFleet(String name){
        this.name = name;
        fleet = new ArrayList<>();
        /* Scelta l'implementazione ArrayList perchè ha un bassissimo costo computazionale
           per le operazioni di size, isEmpty, set, get, iterator rispetto a LinkedList
           queste sono le operazioni maggiormente richieste come specifica la traccia. */
    }
    
    public void add(Truck t) throws NotValidChassisIDException {
        if(! t.validateTruck()) throw new NotValidChassisIDException("NotValidChassisIDException");
        
        fleet.add(t);
        
        /* per farli mettere nel loro ordine naturale: rispetto al compareTo di Truck */
//        Set<Truck> setTmp = new TreeSet<>(fleet);
//        fleet.clear();
//        fleet.addAll(setTmp);
    }
    
    public void remove(Truck t){
        fleet.remove(t);
    }
    
    public void sort(Comparator<Truck> c){
        fleet.sort(c); /* il controllo di c==null è fatto già nell'implementazione di sort */
    }
    
    public Iterator<Truck> iterator(){
        return fleet.iterator();
    }
    
    
    @Override
    public TruckFleet filter(TruckFilter f, Comparator<Truck> c) {
        TruckFleet outFleet = new TruckFleet(name);
        
        for(Truck ti : fleet){
            if(f.checkTruck(ti)){
                try{
                    outFleet.add(ti);
                }catch(NotValidChassisIDException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        outFleet.sort(c);
        return outFleet;
    }
    
    @Override
    public String toString(){
        String strTmp = "\nMy "+name+" contains "+fleet.size()+" trucks. \nListing:\n";
        StringBuffer strb = new StringBuffer(strTmp);
        
        for(Truck ti : fleet){
            strb.append("\n").append(ti).append("\n");
        }
        
        return strb.toString();
    }
}
