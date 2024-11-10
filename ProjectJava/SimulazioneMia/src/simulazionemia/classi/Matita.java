package simulazionemia.classi;

import simulazionemia.enums.MatitaModello;
import simulazionemia.exceptions.ConsumatoException;

public class Matita extends StrumentoScrittura {
    private final MatitaModello modello;
    private double lunghezza;

    public Matita(String id, String proprietario, double prezzo, MatitaModello modello) {
        super(id, proprietario, prezzo);
        
        this.modello = modello;
        this.lunghezza = 17;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public MatitaModello getModello() {
        return modello;
    }

    public void setLunghezza(double lunghezzaConsumata) throws ConsumatoException {
        if(lunghezza < lunghezzaConsumata) throw new ConsumatoException();
        lunghezza -= lunghezzaConsumata;
    }

    @Override
    public String toString() {
        return super.toString()+"\n-Tipo: Matita "+modello+"\n-Lunghezza rimanente: "+lunghezza+" cm";
    }
}
