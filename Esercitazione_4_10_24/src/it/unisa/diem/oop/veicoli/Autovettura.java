package it.unisa.diem.oop.veicoli;

public class Autovettura extends Veicolo{
    private final int numeroPosti;
    
    public Autovettura(String numTelaio, String modello, String alimentazione, String targa, int numeroPosti){
        super(numTelaio, modello, alimentazione, targa);
        this.numeroPosti = numeroPosti;
    }
    
    public int getNumeroPosti(){
        return this.numeroPosti;
    }
    
    @Override
    public boolean controllaTarga(){
        return super.getTarga().matches("[A-Z]{2}[0-9]{3}[A-Z]{2}");
        /*
        String targa = super.getTarga();
        int i;
        if(targa.length() != 7){
            return false;
        }        
        
        for(i=0;  i<=1;  i++){
            if( !Character.isLetter(targa.charAt(i)) ){
                return false;
            }
        }
        for(i=2;  i<=4;  i++){
            if( !Character.isDigit(targa.charAt(i)) ){
                return false;
            }
        }
        for(i=5;  i<=6;  i++){
            if( !Character.isLetter(targa.charAt(i)) ){
                return false;
            }
        }
        
        return true; */
    }
    
    @Override
    public String toString(){
        return super.toString()+", Numero posti = "+this.numeroPosti;
    }
}
