package it.unisa.diem.oop.box;
import it.unisa.diem.oop.box.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop.box.exceptions.BoxException;
import it.unisa.diem.oop.veicoli.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRimessa {
    public static void main(String[] args) {
        Autorimessa autorimessa = new Autorimessa(5, "Parcheggio E1");
        
        try {
            autorimessa.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            autorimessa.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            autorimessa.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            autorimessa.entra(new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            autorimessa.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            autorimessa.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
        } catch (AutorimessaPienaException ex) {
            System.err.println(ex.getMessage());
        } catch (TargaNonValidaException ex) {
            System.err.println(ex.getMessage());
        }        
        
        System.out.println(autorimessa);
    }
}

