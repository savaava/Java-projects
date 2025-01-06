package simulazioneeqr;

import java.time.LocalDateTime;

/*
#EventID|Time|Latitude|Longitude|Depth/Km|Author|Catalog|Contributor|ContributorID|MagTyp
e|Magnitude|MagAuthor|EventLocationName
*/
public class EQEvent implements Comparable<EQEvent>{
    String eventId, author, catalog, contributor, contributorId, magType, magAuthor, location;
    LocalDateTime time;
    float lat, lon, depthKm, mag;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContributorId() {
        return contributorId;
    }

    public void setContributorId(String contributorId) {
        this.contributorId = contributorId;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getMagAuthor() {
        return magAuthor;
    }

    public void setMagAuthor(String magAuthor) {
        this.magAuthor = magAuthor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getDepthKm() {
        return depthKm;
    }

    public void setDepthKm(float depthKm) {
        this.depthKm = depthKm;
    }

    public float getMag() {
        return mag;
    }

    public void setMag(float mag) {
        this.mag = mag;
    }
    
    @Override
    public int compareTo(EQEvent e){
        return eventId.compareTo(e.eventId);
    }
    
    @Override
    public String toString(){
        return String.format("#%s|%s|%.4f|%.4f|%.2f|%s|%s|%s|%s|%s|%.2f|%s|%s", 
            eventId, 
            time, 
            lat, 
            lon, 
            depthKm, 
            author, 
            catalog, 
            contributor, 
            contributorId, 
            magType, 
            mag, 
            magAuthor, 
            location);
    }
}
