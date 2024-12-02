package it.unisa.diem.oop.developed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class EQReport {
    private final List<EQEvent> eventi;
    
    public EQReport(){
        eventi = new LinkedList<>();
    }
    
    public void addEvent(EQEvent e){
        eventi.add(e);
    }
    
    public void sort(){
        eventi.sort(null); /* ordinamento naturale secondo compareTo */
    }
    
    public void sort(Comparator<EQEvent> c){
        eventi.sort(c); /* ordinamento secondo comparatore */
    }
    
    /*#EventID|Time|Latitude|Longitude|Depth/Km|Author|Catalog|Contributor|ContributorID|MagTyp
e|Magnitude|MagAuthor|EventLocationName*/
    public static void printToTextFile(EQReport eqr, String filename) {
        System.out.println("*****Scrittura CSV iniziata*****");
        
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(EQEvent e : eqr.eventi){
                Double lat = e.getLatitude();
                Double lon = e.getLongitude();
                Double depthKm = e.getDepthKm();
                Double mag = e.getMagnitude();
                
                pw.append(e.getEventId()).append("|");
                pw.append(e.getTime().toString()).append("|");                
                pw.append(lat.toString()).append("|");
                pw.append(lon.toString()).append("|");
                pw.append(depthKm.toString()).append("|");
                pw.append(e.getAuthor()).append("|");
                pw.append(e.getCatalog()).append("|");
                pw.append(e.getContributor()).append("|");
                pw.append(e.getContributorId()).append("|");
                pw.append(e.getMagType()).append("|");
                pw.append(mag.toString()).append("|");
                pw.append(e.getMagAuthor()).append("|");
                pw.append(e.getEventLocationName()).append("|").append("\n");
            }
            System.out.println("*****Scrittura CSV completata*****");
        }catch(IOException ex){
            System.out.println("*****Scrittura CSV non completata*****");
        }
    }
    
    public static EQReport readFromTextFile(String filename){
        System.out.println("*****Lettura CSV iniziata*****");
        EQReport reportLetto = new EQReport();
        
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            scan.useDelimiter("[|\n]");
            scan.useLocale(Locale.US);
            while(scan.hasNext()){
                String eventId = scan.next();
                
                String time = scan.next();
                String vettTime[] = time.split("[-T:.]");
                int year = Integer.parseInt(vettTime[0]);
                int month = Integer.parseInt(vettTime[1]);
                int day = Integer.parseInt(vettTime[2]);
                int h = Integer.parseInt(vettTime[3]);
                int min = Integer.parseInt(vettTime[4]);
                int sec = Integer.parseInt(vettTime[5]);
                int nSec = Integer.parseInt(vettTime[6]);
                LocalDateTime timeDate = LocalDateTime.of(year, month, day, h, min, sec, nSec);
                
                double lat = scan.nextDouble();
                double lon = scan.nextDouble();
                double depthKm = scan.nextDouble();
                String author = scan.next();
                String catalog = scan.next();
                String contributor = scan.next();
                String contributorId = scan.next();
                String magT = scan.next();
                double mag = scan.nextDouble();
                String magAuth = scan.next();
                String location = scan.next();
                
                EQEvent e = new EQEvent(eventId,
                        timeDate,
                        lat, 
                        lon,
                        depthKm,
                        author, 
                        catalog, 
                        contributor, 
                        contributorId,
                        magT, 
                        mag, 
                        magAuth, 
                        location);
                reportLetto.addEvent(e);
            }
            System.out.println("*****Lettura CSV completata*****");
        }catch(IOException ex){
            System.out.println("*****Lettura CSV non completata*****");
        }
        
        return reportLetto;
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        for(EQEvent e : eventi){
            strb.append(e);
        }
        
        return strb.toString();
    }
}
