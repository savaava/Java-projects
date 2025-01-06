package gestioneesamisimulazione;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class LibrettoEsami {
    private final Set<EsameSuperato> libretto;
    
    public LibrettoEsami(){
        libretto = new TreeSet<>();
    }
    
    public void aggiungiEsame(EsameSuperato e){
        libretto.add(e);
    }
    public void aggiungiEsami(Collection<EsameSuperato> c){
        libretto.addAll(c);
    }
    
    public Collection<EsameSuperato> filtroPerMatricola(String matricola){
        Collection<EsameSuperato> out = new ArrayList<>();
        
        for(EsameSuperato ei : libretto){
            if(ei.getMatricolaStudente().equals(matricola))
                out.add(ei);
        }
        
        return out;
    }
    public Collection<String> filtroPerNomeInsegnamento(String insegnamento){
        Collection<String> out = new ArrayList<>();
        
        for(EsameSuperato ei : libretto){
            if(ei.getNomeInsegnamento().equalsIgnoreCase(insegnamento))
                out.add(ei.getMatricolaStudente());
        }
        
        return out;
    }
    
    public void caricamentoDaFileTxt(String filename){
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            scan.useDelimiter("[,\n]");
            scan.useLocale(Locale.ITALY);
            
            while(scan.hasNext()){
                String matricolaStudente = scan.next();
                LocalDate data = LocalDate.parse(scan.next());
                String nomeInsegnamento = scan.next();
                int voto = scan.nextInt();
                
                aggiungiEsame(new EsameSuperato(matricolaStudente,data,nomeInsegnamento,voto));
            }
        }catch(IOException ex){System.out.println("Eccezione IO in letturaCSV:\n");ex.printStackTrace();}
    }
    
    public static LibrettoEsami letturaSer(String filename){
        LibrettoEsami librettoLetto = new LibrettoEsami();
        
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            try{
                librettoLetto.aggiungiEsami((Collection<EsameSuperato>)ois.readObject());
            }catch(ClassNotFoundException ex){
                System.out.println("Eccezione IO in letturaSer:\n");
                ex.printStackTrace();
            }
        }catch(IOException ex){
            System.out.println("Eccezione IO in letturaSer:\n");
            ex.printStackTrace();
        }
        
        return librettoLetto;
    }
    public void scritturaSer(String filename){
       try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
           oos.writeObject(libretto);
       }catch(IOException ex){System.out.println("Eccezione IO in scritturaSer:\n");ex.printStackTrace();}
    }
    
    public Collection<EsameSuperato> getLibrettoOrdinato(Comparator<EsameSuperato> c){
        List<EsameSuperato> out = new ArrayList<>(libretto);
        out.sort(c);        
        return out;
    }
    
    @Override
    public String toString(){
        return "Esami presenti nel libretto:"+libretto.size()+"\nElenco:\n"+libretto.toString();
    }
}
