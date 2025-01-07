package simulazionesava;

import java.time.LocalDate;

public class Evento implements java.io.Serializable {
    private final LocalDate data;
    private final String descrizione;
    
    public Evento(LocalDate data, String descrizione){
        this.data = data;
        this.descrizione = descrizione;
    }
    
    public LocalDate getData(){
        return data;
    }    
    public String getDescrizione(){
        return descrizione;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        
        Evento objE = (Evento)obj;
        return objE.data.equals(data);
    }
    
    @Override
    public String toString(){
        return "Evento in Data: "+data+" - Descrizione: "+descrizione+"\n";
    }
}
