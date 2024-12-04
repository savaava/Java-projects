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
    
    /* formato di ciascuna riga di un file di report:
    #EventID|Time|Latitude|Longitude|Depth/Km|Author|Catalog|Contributor|ContributorID|MagType|
    Magnitude|MagAuthor|EventLocationName
    */
    public static void printToTextFile(EQReport eqr, String filename) {
        System.out.println("***** Scrittura iniziata *****");
        
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
            System.out.println("***** Scrittura completata *****\n");
        }catch(IOException ex){
            System.out.println("***** Scrittura non completata *****\n");
        }
    }
    
    public static EQReport readFromTextFile(String filename){
        System.out.println("****** Lettura file con scan iniziata ******");
        EQReport reportLetto = new EQReport();
        
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            scan.useDelimiter("[|\n]");
            scan.useLocale(Locale.US);
            while(scan.hasNext()){                
                String eventId = scan.next();                
                LocalDateTime timeDate = LocalDateTime.parse(scan.next());
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
            System.out.println("****** Lettura file con scan completata ******\n");
        }catch(IOException ex){
            System.out.println("****** Lettura file con scan non completata ******\n");
        }
        
        return reportLetto;
    }
    
    public static EQReport readFromTextFileNoScan(String filename) {
        EQReport reportLetto = new EQReport();
        System.out.println("****** Lettura file senza scan iniziata ******");
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = br.readLine();
            while(line != null){
                String campi[] = line.split("[|]");
                
                String eventId = campi[0];
                LocalDateTime time = LocalDateTime.parse(campi[1]);
                double latitude = Double.parseDouble(campi[2]);
                double longitude = Double.parseDouble(campi[3]);                
                double depthKm = Double.parseDouble(campi[4]);
                String author = campi[5];
                String catalog = campi[6];
                String contributor = campi[7];
                String contributorId = campi[8];
                String magType = campi[9];
                double magnitude = Double.parseDouble(campi[10]);
                String magAuthor = campi[11];
                String eventLocationName = campi[12];
                
                EQEvent e = new EQEvent(eventId,
                        time,
                        latitude, 
                        longitude,
                        depthKm,
                        author, 
                        catalog, 
                        contributor, 
                        contributorId,
                        magType, 
                        magnitude, 
                        magAuthor, 
                        eventLocationName);
                reportLetto.addEvent(e);
                
                line = br.readLine();
            }
            
            System.out.println("****** Lettura file senza scan completata ******\n");
        }catch(IOException ex){
            System.out.println("****** Lettura file senza scan non completata ******\n");
        }
        
        return reportLetto;
    }
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer();
        
        for(EQEvent e : eventi){
            strb.append(e).append("\n");
        }
        
        return strb.toString();
    }
}
