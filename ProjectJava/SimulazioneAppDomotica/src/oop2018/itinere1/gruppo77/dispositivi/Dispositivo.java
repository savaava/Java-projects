package oop2018.itinere1.gruppo77.dispositivi;

public abstract class Dispositivo {
    private final int id;
    private boolean acceso;
    
    public Dispositivo(int id){
        this.id=id;
        this.acceso=true;
    }
    
    public int getId(){
        return id;
    }
    public boolean isAcceso(){
        return acceso;
    }
    
    
    public void accendi(){
        acceso=true;
    }
    public void spegni(){
        acceso=false;
    }
    
    
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }    
    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(obj==this) /* proprietà riflessiva */
            return true;
        if(!(obj instanceof Dispositivo)) /* proprietà asimettrica */
            return false;
        
        Dispositivo objDispositivo = (Dispositivo)obj;
        return objDispositivo.id==this.id;
    }
    
    @Override
    public String toString(){
        if(acceso)
            return "ID dispositivo: "+id+", Stato: Acceso ";
        return "ID dispositivo: "+id+", Stato: Non acceso ";
    }
}
