package it.unisa.diem.oop.box;
import it.unisa.diem.oop.box.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop.box.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop.veicoli.Veicolo;

public class Autorimessa extends Box {
    // COMPLETARE DEFINENDO GLI ATTRIBUTI NECESSARI
    private int testa;
    private int coda;
    private int riemp;
    private Veicolo veicoli[];
  
    public Autorimessa(int maxPosti, String nome) {
        // DA COMPLETARE
        super(maxPosti, nome);
        this.riemp = 0;
        this.coda = 0;
        this.testa = 0;
        this.veicoli = new Veicolo[super.maxPosti];
    }

    private boolean autorimessaPiena() {
               // DA COMPLETARE
        if(this.riemp == super.maxPosti)
            return true;
        else
            return false;
    }

    private boolean autorimessaVuota() {
                // DA COMPLETARE
        if(this.riemp == 0)
            return true;
        else
            return false;
    }

    @Override
    public void entra( Veicolo v ) throws AutorimessaPienaException, TargaNonValidaException {
                // DA COMPLETARE
        if(this.autorimessaPiena()) throw new AutorimessaPienaException("Autorimessa piena! non può entrare");
        if(!v.controllaTarga()) throw new TargaNonValidaException("TARGA NON VALIDA. NON PUO' ENTRARE !!");
        
        this.veicoli[this.coda] = v;
        this.coda = (this.coda+1)%super.maxPosti;
        this.riemp++;
    }

    @Override
    public Veicolo esce() throws AutorimessaVuotaException {
                // DA COMPLETARE
        if(this.autorimessaVuota()) throw new AutorimessaVuotaException("PIENAA!");
        
        Veicolo tmpVeicolo = this.veicoli[this.testa];
        this.veicoli[this.testa] = null;
        this.testa = (this.testa+1)%super.maxPosti;
        this.riemp--;
        return tmpVeicolo;
    }

    @Override
    public String toString() {
                // DA COMPLETARE
        StringBuffer strb = new StringBuffer();
        strb.append(super.toString());
        strb.append("Veicoli presenti: \n");
        for(int i=0;  i<this.riemp;  i++){
            strb.append(this.veicoli[(this.testa+i)%super.maxPosti].toString()+"\n");
        }
        return strb.toString();
    }

}

