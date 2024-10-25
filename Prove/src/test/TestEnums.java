package test;

import enums.Bussola;
import enums.Day;
//import static enums.Day.MERCOLEDI;

public class TestEnums {
    private Day giornoDellaSettimana;
    
    public TestEnums(){
        giornoDellaSettimana=Day.LUNEDI;
    }
    
    public void setGiornoDellaSettimana(Day giornoDellaSettimana){
        this.giornoDellaSettimana = giornoDellaSettimana;
    }
    
    public Day getGiornoDellaSettimana(){
        return giornoDellaSettimana;
    }
    
    public void metodo(){
        switch(giornoDellaSettimana){
            case LUNEDI:
                System.out.println("E' lunedi e sei fottuto");
                break;
            case VENERDI:
                System.out.println("ja è venerdi hai finito praticamente");
                break;
            case SABATO: case DOMENICA:
                System.out.println("è il weekend stai chill");
                break;
            default:
                System.out.println("non è lunedi ci sei quasi");
                break;
        }
    }
    
    public static void main(String[] args) {
        TestEnums o = new TestEnums();
        o.setGiornoDellaSettimana(Day.MERCOLEDI);
        System.out.println(o.getGiornoDellaSettimana());
        o.metodo();
        o.setGiornoDellaSettimana(Day.SABATO);
        System.out.println(o.getGiornoDellaSettimana());
        o.metodo();
        
        
        Bussola.NORD.stampaMessaggio();
        Bussola.SUD.stampaMessaggio();
        
        Bussola bussolaDaTaschino = Bussola.OVEST;
        bussolaDaTaschino.stampaMessaggio();
    }
}
