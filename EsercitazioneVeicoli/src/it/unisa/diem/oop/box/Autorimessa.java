package it.unisa.diem.oop.box;
import it.unisa.diem.oop.box.exceptions.TargaNonValidaException;
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
        this.veicoli = new Veicolo[super.getMaxPosti()];
    }

    private boolean autorimessaPiena() {
        // DA COMPLETARE
        return (this.riemp == super.getMaxPosti());
    }

    private boolean autorimessaVuota() {
        // DA COMPLETARE
        return (this.riemp == 0);
    }

    @Override
    public void entra( Veicolo v ) throws AutorimessaPienaException, TargaNonValidaException {
        // DA COMPLETARE
        if(this.autorimessaPiena()) throw new AutorimessaPienaException("Autorimessa piena. NON PUO' ENTRARE");
        if(!v.controllaTarga()) throw new TargaNonValidaException("Targa non valida. NON PUO' ENTRARE");
        
        System.out.println("Entra veicolo #"+(this.riemp+1)+"/"+super.getMaxPosti()+"...");
        this.veicoli[this.coda] = v;
        this.coda = (this.coda+1)%super.getMaxPosti();
        this.riemp++;
    }

    @Override
    public Veicolo esce() throws AutorimessaVuotaException {
        // DA COMPLETARE
        if(this.autorimessaVuota()) throw new AutorimessaVuotaException("Autorimessa vuota. NON PUO' USCIRE NESSUN VEICOLO");
        
        System.out.println("Esce veicolo #"+(this.riemp)+"/"+super.getMaxPosti()+"...");
        Veicolo tmpVeicolo = this.veicoli[this.testa];
        this.veicoli[this.testa] = null;
        this.testa = (this.testa+1)%super.getMaxPosti();
        this.riemp--;
        return tmpVeicolo;
    }

    @Override
    public String toString() {
        // DA COMPLETARE
        StringBuffer strb = new StringBuffer();
        strb.append(super.toString());
        strb.append("Veicoli presenti ("+this.riemp+"/"+super.getMaxPosti()+"): \n");
        for(int i=0;  i<this.riemp;  i++){
            strb.append("#"+(i+1)+"/"+super.getMaxPosti()+" -> ").append(this.veicoli[(this.testa+i)%super.getMaxPosti()].toString()+"\n");
        }
        return strb.toString();
    }

}

