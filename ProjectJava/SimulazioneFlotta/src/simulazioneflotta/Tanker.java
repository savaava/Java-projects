package simulazioneflotta;


public class Tanker extends Truck {
    
   private final int totalCapacity;
   private final int compartments;
   private final boolean foodGrade;

    public Tanker(Truck tractor, int totalCapacity, int compartments, boolean foodGrade){
        super(tractor.getChassisID(), tractor.getRegistrationDate());
        
        if(totalCapacity<5000 || totalCapacity>25000 || compartments>4)
            throw new IllegalArgumentException("Invalid total capacity value or bad compartments number");
        
        this.totalCapacity = totalCapacity;
        this.compartments = compartments;
        this.foodGrade = foodGrade;
    }
   

    public int getTotalCapacity() {
       return totalCapacity;
    }

    public int getCompartments() {
        return compartments;
    }

    public boolean isFoodGrade() {
        return foodGrade;
    }
    
    

    @Override
    public String toString() {
       return super.toString()+"->Tanker{totalCapacity="+this.totalCapacity+", compartements="+this.compartments+", foodGrade="+this.foodGrade+"}";
    }
}
