package figure;
import figureconcrete.*;

public class TestFigure {
    public static void main(String[] args) {
        Cerchio c1 = new Cerchio();
        Cerchio c2 = new Cerchio("c2 :) ", 7F);        
        System.out.println(c1);
        System.out.println("Perimetro c1: "+c1.calcolaPerimetro()+"\nArea c1: "+c1.calcolaArea()+"\n");
        System.out.println(c2);
        System.out.println("Perimetro c2: "+c2.calcolaPerimetro()+"\nArea c2: "+c2.calcolaArea()+"\n");
        
        Sfera s1 = new Sfera();
        Sfera s2 = new Sfera("s1 :)) ", 7F);
        System.out.println(s1);
        System.out.println("Area s1: "+s1.calcolaArea()+"\nVolume s1: "+s1.calcolaVolume()+"\n");
        System.out.println(s2);
        System.out.println("Area s2: "+s2.calcolaArea()+"\nVolume s2: "+s2.calcolaVolume());
    }
}
