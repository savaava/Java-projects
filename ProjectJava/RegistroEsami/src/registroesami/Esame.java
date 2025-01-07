package registroesami;

import java.time.LocalDate;
import java.time.DateTimeException;

public class Esame implements java.io.Serializable {
    private final String nome;
    private final LocalDate data;
    private final int voto;
    private final String codice;
    
    private Esame(String nome, LocalDate data, int voto, String codice){        
        this.nome = nome;
        this.data = data;
        this.voto = voto;
        this.codice = codice;
    }
    
    public String getNome(){
        return nome;
    }
    public LocalDate getData(){ /* Deep copy */
        return LocalDate.of(data.getYear(),
                            data.getMonthValue(),
                            data.getDayOfMonth());
    }
    public int getVoto(){
        return voto;
    }
    public String getCodice(){
        return codice;
    }
    
    @Override
    public int hashCode(){
        return codice.toLowerCase().hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        
        Esame objE = (Esame)obj;
        return objE.codice.equalsIgnoreCase(codice);
    }
    
    @Override
    public String toString(){
        return "Esame{nome="+nome+
               ", data="+data+
               ", voto="+voto+
               ", codice="+codice+"}";
    }
    
    public static Esame crea(String nome, int giorno, int mese, int anno, int voto, String codice){
        try{LocalDate.of(anno, mese, giorno);}
        catch(DateTimeException ex){throw new DataNonValidaException("data fornita non valida");}
        if(voto<18 || voto>31) throw new VotoNonValidoException("voto fornito non compreso in [18,31]");
        if(codice == null) throw new CodiceNonValidoException("codice fornito uguale a null");
        
        return new Esame(nome, LocalDate.of(anno, mese, giorno), voto, codice);
    }
}
