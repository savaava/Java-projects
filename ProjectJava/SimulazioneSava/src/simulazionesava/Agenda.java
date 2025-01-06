package simulazionesava;

import java.io.IOException;
import java.time.LocalDate;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import java.io.*;
import java.util.Scanner;

public class Agenda implements java.io.Serializable {
    private final String proprietario;
    private final List<Map<LocalDate,Evento>> agenda;
    
    public Agenda(String proprietario){
        this.proprietario = proprietario;
        agenda = new ArrayList<>();
    }
    
    
    public String getProprietario(){
        return proprietario;
    }
    
    public void aggiungiEvento(Evento e){
        for(int i=0; i<agenda.size(); i++){
            if(agenda.get(i).size()<4){
                agenda.get(i).put(e.getData(),e);
                return;
            }
        }
        agenda.add(new TreeMap<>());
        agenda.get(agenda.size()-1).put(e.getData(),e);
    }
    
    public void rimuoviEventi(LocalDate data){
        agenda.forEach(sezioneEventi -> sezioneEventi.remove(data));
    }
    
    public Collection<Evento> getEventi(LocalDate data){
        Collection<Evento> out = new ArrayList<>();
        agenda.forEach(sezioneEventi -> {
            Evento e = sezioneEventi.get(data);
            if(e!=null) out.add(e);
        });
        return out;
    }
    
    public int getNumEventi(){
        int out = 0;
        
        for(Map<LocalDate,Evento> sezioneEventi : agenda){
            out+=sezioneEventi.size();
        }
        
        return out;
    }
    
    
    public void saveOBJ(String filename) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            oos.writeObject(this);
        }
    }
    public static Agenda readOBJ(String filename) throws IOException{
        Agenda out = null;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            try{out = (Agenda)ois.readObject();
            }catch(ClassNotFoundException ex){ex.printStackTrace();}
        }
        return out;
    }
    
    public void saveCSV(String filename) throws IOException{
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            agenda.forEach(sezioneEventi -> {
                sezioneEventi.values().forEach(e -> {
                    pw.append(e.getData().toString()).append(",");
                    pw.append(e.getDescrizione()).append("\n");
                });
            });
        }
    }
    public static Agenda readCSV(String filename) throws IOException{
        Agenda out = null;
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            out = new Agenda(filename.split("[.]")[0]);
            scan.useDelimiter("[,\n]");
            while(scan.hasNext()){
                out.aggiungiEvento(new Evento(LocalDate.parse(scan.next()), scan.next()));
            }
        }
        return out;
    }
    
    
    @Override
    public String toString(){
        String titolo = "Agenda completa di "+proprietario
                +" ("+agenda.size()+" sezioni - "+getNumEventi()+" eventi)"+"\n";
        StringBuffer strb = new StringBuffer(titolo);
        
        int i=0;
        for(Map<LocalDate,Evento> sezioneEventi : agenda){
            strb.append("***** Sezione ").append(++i).append(" *****\n");
            if(sezioneEventi.isEmpty()){
                strb.append("Nessun Evento nella sezione\n");
            }else{
                sezioneEventi.values().forEach(e -> strb.append(e));
            }
        }
        
        return strb.toString();
    }
}
