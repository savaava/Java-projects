package it.unisa.diem.oop.developed.group77;

import it.unisa.diem.oop.provided.DeviceFilter;

public class HighStorageDeviceFilter implements DeviceFilter {
    private final int minSize;
    
    public HighStorageDeviceFilter(int minSize){
        this.minSize = minSize;
    }
    
    
    @Override
    public boolean checkDevice(Device d){
        return d.getStorageCapacity() >= this.minSize;
    }
}
