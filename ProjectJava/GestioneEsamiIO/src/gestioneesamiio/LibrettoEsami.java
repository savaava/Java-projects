package gestioneesamiio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LibrettoEsami implements Serializable {
    private final Set<EsameSuperato> esami;
    
    public LibrettoEsami(){
        esami = new TreeSet<>();
    }
    
    public int numeroEsami(){
        return esami.size();
    }
    
    public void aggiungiEsame(EsameSuperato e){
        esami.add(e);
    }
    
    public Collection<String> getEsamiDaMatricola(String matricola) {
        Set<String> out = new TreeSet<>();
        
        for(EsameSuperato e : esami){
            if(e.getMatricolaStudente().equalsIgnoreCase(matricola)){
                out.add(e.getNomeEsame());
            }
        }
        
        return out;
    }
            
    public Collection<String> getStudentiDaEsame(String nomeEsame) {
        Set<String> out = new TreeSet<>();
        
        for(EsameSuperato e : esami){
            if(e.getNomeEsame().equalsIgnoreCase(nomeEsame)){
                out.add(e.getMatricolaStudente());
            }
        }
        
        return out;
    }
    
    public Collection<EsameSuperato> getLibrettoOrdinato(Comparator<EsameSuperato> c) {
        List<EsameSuperato> out = new ArrayList<>(esami);        
        out.sort(c);
        
        return out;
    }
    
    public void salvataggioOBJ(String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(this);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }    
    public static LibrettoEsami caricamentoOBJ(String filename) {
        LibrettoEsami librettoLetto = null;
        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            try {
                librettoLetto = (LibrettoEsami)ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        return librettoLetto;
    }
    
    /* formato:  MatricolaStudente, Anno-Mese-Giorno, NomeInsegnamento, Voto */
    public void printToTextFile(String filename) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for(EsameSuperato e : esami) {
                pw.append(e.getMatricolaStudente()).append(", ");
                pw.append(e.getDataSuperamento().toString()).append(", ");
                pw.append(e.getNomeEsame()).append(", ");
                pw.append(Double.toString(e.getVoto())).append("\n");
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static LibrettoEsami readFromTextFile(String filename) {
        LibrettoEsami librettoLetto = new LibrettoEsami();
        
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))){
            s.useDelimiter("[,\n]");
            s.useLocale(Locale.ITALY);
            
            while(s.hasNext()){
                String matricola = s.next();
                LocalDate time = LocalDate.parse(s.next());
                String nome = s.next();
                double voto = Double.parseDouble(s.next());
                
                librettoLetto.aggiungiEsame(new EsameSuperato(matricola, time, nome, voto));
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        return librettoLetto;
    }
    
    @Override
    public String toString(){
        return "Esami presenti nel libretto:"+numeroEsami()+"\nElenco:\n"+esami;
    }
}
