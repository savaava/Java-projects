package it.unisa.diem.oop.developed.group77;

import java.time.LocalDate;

public abstract class Device implements Comparable<Device> {
    private final String serialNumber;
    private final LocalDate releaseDate;
    private final int RAMsize;
    private final int storageCapacity;
    
    public Device(String serialNumber, int year, int month, int dayOfMonths, int RAMsize, int storageCapacity){
        this.serialNumber = serialNumber;
        releaseDate = LocalDate.of(year, month, dayOfMonths);
        this.RAMsize = RAMsize;
        this.storageCapacity = storageCapacity;
    }
    
    
    public String getSerialNumber(){
        return serialNumber;
    }
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    public int getRAMsize(){
        return RAMsize;
    }
    public int getStorageCapacity(){
        return storageCapacity;
    }
    
    
    public abstract boolean hasTouchScreen();
    
    
    @Override
    public final int compareTo(Device o){ /* final per non essere ridefinito */
        return this.serialNumber.compareTo(o.serialNumber); /* compareTo di String */
    }    
    
    @Override
    public int hashCode(){
        return this.serialNumber.hashCode(); /* hashCode di String */
    }   
    
    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(other.getClass() != this.getClass()) /* proprietà simmetrica */
            return false;
        
        Device deviceOther = (Device)other;
        return deviceOther.serialNumber.equalsIgnoreCase(this.serialNumber); /* case insensitive */
    }
    
    @Override
    public String toString(){
        return "serialNumber= "+serialNumber+"\nreleaseDate= "+releaseDate+"\nRAMsize= "+RAMsize+"GB\nstorageCapacity= "+storageCapacity+"GB";
    }
}
