package oop2018.itinere1.gruppo77.dispositivi;

public class Luce extends Attuatore {
    public Luce(int id){
        super(id);
    }
    
    @Override
    public String toString(){
        return super.toString()+" - Tipo: Luce";
    }
}
