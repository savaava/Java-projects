package prove;

import classi.ClasseMadre;
import classi.ClasseFiglia1;

import java.util.ArrayList;
import java.util.List;

public class MainGenerico {
    private int uccelli = 30;
    public int m1(){
        return 2;
    }
    public void m1(int x){
        
    }
    public static void main(String[] args) {
        //uccelli++;
        
        ClasseMadre madre = new ClasseMadre();
        //ClasseFiglia1 figlio = madre;
        
        ArrayList<Integer> interi = new ArrayList<>();
        interi.trimToSize();
        List<Integer> interi2 = new ArrayList<>();
    }
}
