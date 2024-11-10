package it.unisa.diem.oop.box;
import it.unisa.diem.oop.box.exceptions.TargaNonValidaException;
import it.unisa.diem.oop.box.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop.box.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop.veicoli.Autovettura;
import it.unisa.diem.oop.veicoli.Camion;
import it.unisa.diem.oop.veicoli.Moto;

public class TestRimessa {
    public static void main(String[] args) {
        Autorimessa autorimessa1 = new Autorimessa(5, "Parcheggio E1");
        
        /* ha la targa valida: */
        try {
            autorimessa1.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa non valida: */
        try {
            autorimessa1.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa valida: */
        try {
            autorimessa1.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa non valida: */
        try {
            autorimessa1.entra(new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa valida: */
        try {
            autorimessa1.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa non valida: */
        try {
            autorimessa1.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
        } catch (AutorimessaPienaException | TargaNonValidaException ex) {
            System.out.println(ex.getMessage());
        }        
        
        /* ha la targa valida: */
        try{
            autorimessa1.entra(new Autovettura("mk23g", "Fiat Punto", "Gasolio", "DT588TL", 5));
        }catch(AutorimessaPienaException | TargaNonValidaException ex){
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa valida: */
        try{
            autorimessa1.entra(new Autovettura("mk23g", "Fiat Punto", "Gasolio", "DT588TL", 5));
        }catch(AutorimessaPienaException | TargaNonValidaException ex){
            System.out.println(ex.getMessage());
        }
        
        /* ha la targa valida MA l'autorimessa è PIENA */
        try{
            autorimessa1.entra(new Autovettura("mk23g", "Fiat Punto", "Gasolio", "DT588TL", 5));
        }catch(AutorimessaPienaException | TargaNonValidaException ex){
            System.out.println(ex.getMessage());
        }
        
        /* 5/5 veicoli */
        System.out.println(autorimessa1);
        
        /* autorimessa non vuota */
        try{
            autorimessa1.esce();
            autorimessa1.esce();
            autorimessa1.esce();
            autorimessa1.esce();
            autorimessa1.esce();
        }catch(AutorimessaVuotaException ex){
            System.out.println(ex.getMessage());
        }
        
        /* 0/5 veicoli */
        System.out.println(autorimessa1);
        
        /* autorimessa vuota */
        try{
            autorimessa1.esce();
        }catch(AutorimessaVuotaException ex){
            System.out.println(ex.getMessage());
        } 
    }
}

