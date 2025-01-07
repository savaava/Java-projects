package ausiliarie;

import java.time.LocalDate;
import java.util.Random;

public class Evento implements java.io.Serializable {
    private final LocalDate data;
    private final String descrizione;
    private static final Random n = new Random(333);
    
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
    
    public static Evento getEventoCasuale(){        
        int anno = n.nextInt(51)+2025;
        int mese = n.nextInt(12)+1;
        int giorno = n.nextInt(LocalDate.of(anno,mese,1).lengthOfMonth())+1;
        
        String[] descrizioni = {
            "BedWars Gis",
            "Esercitazione ASD",
            "Esercitazione OOP",
            "D&D",
            "Teatro Verdi",
            "Riunione con Rocco",
            "Rimpatriata coi bro",
            "Festa Dakunto"
        };
        String descrizioneCasuale = descrizioni[n.nextInt(descrizioni.length)];
        
        return new Evento(LocalDate.of(anno, mese, giorno), descrizioneCasuale);
    }
    
    @Override
    public String toString(){
        return "Evento in Data: "+data+" - Descrizione: "+descrizione+"\n";
    }
}
