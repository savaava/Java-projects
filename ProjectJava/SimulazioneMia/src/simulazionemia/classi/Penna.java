package simulazionemia.classi;

import simulazionemia.enums.PennaMarchio;
import simulazionemia.exceptions.ConsumatoException;

public class Penna extends StrumentoScrittura {
    private final PennaMarchio marchio;
    private double inchiostro;

    public Penna(String id, String proprietario, double prezzo, PennaMarchio marchio, double inchiostro) {
        super(id, proprietario, prezzo);
        
        this.marchio = marchio;
        this.inchiostro = inchiostro;
    }

    public double getInchiostro() {
        return inchiostro;
    }

    public PennaMarchio getMarchio() {
        return marchio;
    }

    public void setInchiostro(double inchiostroConsumato) throws ConsumatoException {
        if(inchiostro < inchiostroConsumato) throw new ConsumatoException();
        inchiostro -= inchiostroConsumato;
    }

    @Override
    public String toString() {
        return super.toString()+"\n-Tipo: Penna "+marchio+" \n-Inchiostro rimanente: "+inchiostro+" ml";
    }
}
