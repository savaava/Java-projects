package simulazioneeqr;

import java.io.*;
import java.util.Scanner;
import java.util.Locale;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import java.time.LocalDateTime;

public class EQReport {
    List<EQEvent> report;
    
    public EQReport(){
        report = new ArrayList<>();
    }
    
    public void addEvent(EQEvent e){
        report.add(e);
    }
    
    public void sort(){
        report.sort(null);
    }    
    public void sort(Comparator<EQEvent> c){
        report.sort(c);
    }
    
    public static EQReport readFromTextFile(String filename){
        EQReport rRead = new EQReport();
        
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            scan.useLocale(Locale.US);
            scan.useDelimiter("[|\n]");
            
            while(scan.hasNext()){
                EQEvent ei = new EQEvent();
                ei.setEventId(scan.next());
                ei.setTime(LocalDateTime.parse(scan.next()));
                ei.setLat(scan.nextFloat());
                ei.setLon(scan.nextFloat());
                ei.setDepthKm(scan.nextFloat());
                ei.setAuthor(scan.next());
                ei.setCatalog(scan.next());
                ei.setContributor(scan.next());
                ei.setContributorId(scan.next());
                ei.setMagType(scan.next());
                ei.setMag(scan.nextFloat());
                ei.setMagAuthor(scan.next());
                ei.setLocation(scan.next());
                
                rRead.addEvent(ei);
            }
        }catch(IOException ex){ex.printStackTrace();}
        
        return rRead;
    }
    /* FORMATO file:
    EventID|Time|Latitude|Longitude|Depth/Km|Author|Catalog|Contributor|ContributorID|
    MagType|Magnitude|MagAuthor|EventLocationName
    */
    public static void printToTextFile(EQReport eqr, String filename){
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(EQEvent ei : eqr.report){
                pw.append(ei.getEventId()+"|").append("|");
                pw.append(ei.getTime().toString()).append("|");
                pw.append(Float.toString(ei.getLat())).append("|");
                pw.append(Float.toString(ei.getLon())).append("|");
                pw.append(Float.toString(ei.getDepthKm())).append("|");
                pw.append(ei.getAuthor()).append("|");
                pw.append(ei.getCatalog()).append("|");
                pw.append(ei.getContributor()).append("|");
                pw.append(ei.getContributorId()).append("|");
                pw.append(ei.getMagType()).append("|");
                pw.append(Float.toString(ei.getMag())).append("|");
                pw.append(ei.getMagAuthor()).append("|");
                pw.append(ei.getLocation()).append("\n");
            }
        }catch(IOException ex){ex.printStackTrace();}
    }    
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        for(EQEvent ei : report){
            strb.append(ei).append("\n");
        }
        
        return strb.toString();
    }
}
