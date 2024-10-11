package it.unisa.diem.oop.box;
import it.unisa.diem.oop.box.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop.box.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop.veicoli.Veicolo;

public abstract class Box {

            // DA COMPLETARE
    public int maxPosti;
    private String nome;

    public Box(int maxPosti, String nome) {
               // DA COMPLETARE
            this.maxPosti = maxPosti;
            this.nome = nome;
    }

    public int getMaxPosti() {
             // DA COMPLETARE
            return this.maxPosti; 
    }

    public void setMaxPosti(int maxPosti) {
               // DA COMPLETARE
               this.maxPosti = maxPosti;
    }

    public String getNome() {
               // DA COMPLETARE
               return this.nome;
    }

    public void setNome(String nome) {
                // DA COMPLETARE
                this.nome = nome;
    }

    public abstract void entra(Veicolo v) throws AutorimessaPienaException, TargaNonValidaException;

    public abstract Veicolo esce() throws AutorimessaVuotaException;

    @Override
    public String toString() {
        // DA COMPLETARE
        return "Nome Box="+this.nome+", Capienza= "+this.maxPosti+"\n";
    }

}

