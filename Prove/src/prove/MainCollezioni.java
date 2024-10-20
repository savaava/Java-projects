package prove;

import java.util.LinkedList;
import java.util.List;

public class MainCollezioni {
    public static void main(String[] args) {
        
        List<Integer> interi = new LinkedList<>();
        interi.add(44);
        interi.add(213);
        interi.add(78);
        interi.add(9);
        interi.add(11);
        System.out.println("\n\n"+interi+"\nSIZE: "+interi.size()+"\nlast element: "+interi.get(interi.size()-1));
        List<Integer> interi2 = interi.subList(0,interi.size());
        System.out.println("\n\n"+interi2+"\nSIZE: "+interi2.size()+"\nlast element: "+interi2.get(interi2.size()-1));
    }
}
