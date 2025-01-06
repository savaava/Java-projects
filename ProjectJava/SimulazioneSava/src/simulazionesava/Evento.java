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
    public String toString(){
        return "Evento in Data: "+data+" - Descrizione: "+descrizione+"\n";
    }
}
