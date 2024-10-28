package simulazionemia.classi;

public abstract class StrumentoScrittura {
    private final String id;
    private final String proprietario;
    private final double prezzo;

    public StrumentoScrittura(String id, String proprietario, double prezzo) {
        this.id = id;
        this.proprietario = proprietario;
        this.prezzo = prezzo;
    }

    public String getId(){
        return id;
    }
    
    public double getPrezzo() {
        return prezzo;
    }

    public String getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return "---Strumento scrittura---\n-id: "+id+"\n-proprietario: "+proprietario+"\n-prezzo: "+prezzo+" €";
    }
}
