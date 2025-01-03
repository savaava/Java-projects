package simulazioneaeroportoio;

import java.io.Serializable;

public abstract class Aeromobile implements Cloneable, Serializable {
    private final String codice;
    private final int numeroSequenziale;
    public static int cont = 0;
    
    public Aeromobile(String codice){
        this.codice = codice;
        numeroSequenziale = ++cont;
    }

    public String getCodice() {
        return codice;
    }

    public int getNumeroSequenziale() {
        return numeroSequenziale;
    }
    
//    @Override
//    public boolean equals(Object obj){
//        if(obj == null)
//            return false;
//        if(obj == this)
//            return true;
//        if(obj.getClass() != this.getClass())
//            return false;
//        
//        Aeromobile o = (Aeromobile)obj;
//        return o.codice.equalsIgnoreCase(codice);
//    }
    
    @Override
    public int hashCode(){
        return codice.hashCode();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    @Override
    public String toString(){
        return "Aereomobile n."+numeroSequenziale+" - Codice = "+codice;
    }
}
