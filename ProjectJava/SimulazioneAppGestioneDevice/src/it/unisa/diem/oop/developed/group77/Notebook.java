package it.unisa.diem.oop.developed.group77;

import it.unisa.diem.oop.provided.CPUType;
import it.unisa.diem.oop.provided.NBScreenType;

public class Notebook extends Device {
    private final CPUType type;
    private final NBScreenType screenType;
    private final boolean touchScreen;
    
    public Notebook(CPUType type,NBScreenType screenType,String serialNumber,int year,int month,int dayOfMonth,int RAMsize,int storageCapacity){
        super(serialNumber,year,month,dayOfMonth,RAMsize,storageCapacity);
        
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = false;
    }
    
    public Notebook(CPUType type,NBScreenType screenType,boolean touchScreen,String serialNumber,int year,int month,int dayOfMonth,int RAMsize,int storageCapacity){
        super(serialNumber,year,month,dayOfMonth,RAMsize,storageCapacity);
        
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = touchScreen;
    }
    
    public CPUType getType(){
        return type;
    }
    public NBScreenType getScreenType(){
        return screenType;
    }
    
    
    @Override
    public boolean hasTouchScreen(){
        return touchScreen;
    }
    
    @Override
    public String toString(){
        if(touchScreen)
            return "Notebook\n"+super.toString()+"\nCPU="+type+"\nscreenType="+screenType+"\ntouchScreen available";
        return "Notebook\n"+super.toString()+"\nCPU="+type+"\nscreenType="+screenType;
    }
}
