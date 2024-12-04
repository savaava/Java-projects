package it.unisa.diem.oop.developed;

import java.time.LocalDateTime;

public class EQEvent implements Comparable<EQEvent> {
    private final String eventId;
    private final LocalDateTime time;
    private final double latitude;
    private final double longitude;
    private final double depthKm;
    private final String author;
    private final String catalog;
    private final String contributor;
    private final String contributorId;
    private final String magType;
    private final double magnitude;
    private final String magAuthor;
    private final String eventLocationName;

    public EQEvent(String eventId, LocalDateTime time, double latitude, double longitude, double depthKm, String author, String catalog, String contributor, String contributorId, String magType, double magnitude, String magAuthor, String eventLocationName) {
        this.eventId = eventId;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
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
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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
                +"|"+latitude
                +"|"+longitude
                +"|"+depthKm
                +"|"+author
                +"|"+catalog
                +"|"+contributor
                +"|"+contributorId
                +"|"+magType
                +"|"+magnitude
                +"|"+eventLocationName;
    }
}
