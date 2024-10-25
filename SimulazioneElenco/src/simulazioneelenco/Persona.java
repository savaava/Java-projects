package simulazioneelenco;

import java.time.LocalDate;

public class Persona {
    private final String nome;
    private final LocalDate dataNascita;
    private final String codiceFiscale;

    public Persona(String nome, LocalDate dataNascita, String codiceFiscale) {
        this.nome=nome;
        this.dataNascita=dataNascita;
        this.codiceFiscale=codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    
    @Override
    public int hashCode() {
      return this.codiceFiscale.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(!(obj instanceof Persona))
            return false;
        
        Persona tmp = (Persona)obj;
        return codiceFiscale.equalsIgnoreCase(tmp.codiceFiscale);
    }

    @Override
    public String toString() {
        return "Nome=" + nome + "\nData di nascita=" + dataNascita + "\nCodice fiscale=" + codiceFiscale;
    }
}
