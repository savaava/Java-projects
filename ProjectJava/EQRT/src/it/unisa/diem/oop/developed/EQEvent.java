package it.unisa.diem.oop.developed;

import java.time.LocalDateTime;
//import java.time.Instant;
//import java.time.ZoneId;

public class EQEvent implements Comparable<EQEvent> {
    private final String eventId;
    private final LocalDateTime time;
    private final double Latitude;
    private final double Longitude;
    private final double depthKm;
    private final String author;
    private final String catalog;
    private final String contributor;
    private final String contributorId;
    private final String magType;
    private final double magnitude;
    private final String magAuthor;
    private final String eventLocationName;

    public EQEvent(String eventId, LocalDateTime time, double Latitude, double Longitude, double depthKm, String author, String catalog, String contributor, String contributorId, String magType, double magnitude, String magAuthor, String eventLocationName) {
        this.eventId = eventId;
        this.time = time;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.depthKm = depthKm;
        this.author = author;
        this.catalog = catalog;
        this.contributor = contributor;
        this.contributorId = contributorId;
        this.magType = magType;
        this.magnitude = magnitude;
        this.magAuthor = magAuthor;
        this.eventLocationName = eventLocationName;
    }
    
    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public double getDepthKm() {
        return depthKm;
    }

    public String getAuthor() {
        return author;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributorId() {
        return contributorId;
    }

    public String getMagType() {
        return magType;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getMagAuthor() {
        return magAuthor;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

//    @Override
//    public boolean equals(Object obj){
//        if(obj == null) return false;
//        if(obj == this) return true;
//        if(obj.getClass() != EQEvent.class) return false;
//        
//        EQEvent objEvent = (EQEvent)obj;
//        return objEvent.eventId.equalsIgnoreCase(eventId);
//    }
//
//    @Override
//    public int hashCode() {
//        return eventId.hashCode();
//    }
    
    @Override
    public int compareTo(EQEvent o) {
        return eventId.compareToIgnoreCase(o.eventId);
    }
    
    /*EventID|Time|Latitude|Longitude|Depth/Km|Author|Catalog|Contributor|ContributorID|MagTyp
e|Magnitude|MagAuthor|EventLocationName*/
    @Override
    public String toString(){
        return eventId
                +"|"+time.toString()
                +"|"+Latitude
                +"|"+Longitude
                +"|"+depthKm
                +"|"+author
                +"|"+catalog
                +"|"+contributor
                +"|"+contributorId
                +"|"+magType
                +"|"+magnitude
                +"|"+eventLocationName+"\n";
    }
}
