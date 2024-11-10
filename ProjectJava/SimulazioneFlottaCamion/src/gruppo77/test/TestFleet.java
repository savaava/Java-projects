package gruppo77.test;

import gruppo77.classes.*;
import gruppo77.enums.*;
import gruppo77.exception.NotValidChassisIDException;

// prova in itinere 2 novembre 2021

public class TestFleet {
    public static void main(String[] args) {
        // TODO code application logic here
        
        Truck t1 = new Tanker(TankType.WATER, 12000, "TSSZ353", DriveWheelType.RWD_4X2, 2010, 10, 3, 7 );
        
        Truck t2 = new Tanker(TankType.FUEL, 30000, "TSPZ453", DriveWheelType.RWD_6x4, 2010, 12, 3, TruckType.TANDEM,8);
        
        Truck t3 = new Tanker(TankType.CEMENT, 35000, "TSCZ443", DriveWheelType.RWD_6x4, 2010, 8, 3, TruckType.TRACTOR_TRAILER,8);
        
        Truck t4 = new Tanker(TankType.FUEL, 30000, "TSP2453", DriveWheelType.RWD_6x4, 2010, 12, 3, TruckType.TANDEM,8);
        
        Truck t5 = new Tanker(TankType.WATER, 27000, "TSSZ923", DriveWheelType.AWD_6X6, 2008, 10, 3, 8 );
        
        Truck t6 = new Dumper ("DAB2234", DriveWheelType.RWD_6x4, 2008,11,12, 8);
        
        Truck t7 = new Dumper ("DAC2334", DriveWheelType.RWD_8x4, 2007,11,8, 8);
        
        Truck t8 = new Dumper ("DAC1334", DriveWheelType.AWD_6X6, 2006,11,8, TruckType.STANDARD, 8);
        
        Truck t9 = new Dumper (true,"DAC1334", DriveWheelType.AWD_6X6, 2006, 11, 8, TruckType.STANDARD, 8);
        
        Truck t10 = new BoxTruck ("BFGV234", DriveWheelType.RWD_4X2, 2012,7,3, TruckType.STANDARD,7);
        
        Truck t11 = new BoxTruck (true, "BFLV215", DriveWheelType.RWD_4X2, 2012,4,3, TruckType.STANDARD,7);
        
        Truck t12 = new BoxTruck ( "BFRV215", DriveWheelType.RWD_8x4, 2012,4,3, TruckType.TANDEM,8);
        
        Truck t13 = new BoxTruck ( "BFRT222", DriveWheelType.AWD_4X4, 2012,4,3, TruckType.STANDARD,7);
        
        
        System.out.println("Printing single truck\n\n" + t4);
        
      //  System.out.println("Printing single truck" + t6);
      //  System.out.println("Printing single truck" + t7);
        
        TruckFleet tf = new TruckFleet(" First Fleet ");
        
        //cambiare il valore di questa variabile per testare l'eccezione
        boolean testexception = true;
        
        try{
        tf.add(t1);
        tf.add(t2);
        tf.add(t3);
        tf.add(t5);
        tf.add(t6);
        tf.add(t7);
        tf.add(t8);
        tf.add(t9);
        tf.add(t10);
        tf.add(t11);
        tf.add(t12);
        tf.add(t13);
        }catch(NotValidChassisIDException ex){
            System.out.println(ex.getMessage());
        }
        
        tf.remove(t7);
        
        tf.sort(null);       
        
        if(testexception)   {         
            try{
                tf.add(t4);
            }catch(NotValidChassisIDException ex){
                System.out.println("\nt4 -> "+ex.getMessage());
            }
        }
        
        System.out.println("\n***Natural ordering***");
        System.out.println(tf);
        
        tf.sort(new TruckClassComparator());
        
        System.out.println("\n***Truck class ordering***");
        
        System.out.println(tf);
      
        System.out.println("\n***Testing BigTankerFilter***\n");
        
        TruckFleet tf2 = tf.filter(new BigTankerFilter(18000), null);
        
        System.out.println(tf2);
        
        System.out.println("\n***Testing AWDTruckFilter with TruckClassComparator***\n");
        
        TruckFleet tf3 = tf.filter(new AWDTruckFilter(), new TruckClassComparator());
        
        System.out.println(tf3);
        
    }
    
}

