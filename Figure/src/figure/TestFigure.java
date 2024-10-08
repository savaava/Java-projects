package figure;
import figureconcrete.*;

public class TestFigure {
    public static void main(String[] args) {
        Figura2D foglio[] = new Figura2D[2];
        foglio[0] = new Cerchio();
        foglio[1] = new Cerchio("cerchietto 2", 2.2F);
        System.out.println(foglio[0]);
        System.out.println("Perimetro foglio[0]: "+foglio[0].calcolaPerimetro()+"\nArea foglio[0]: "+foglio[0].calcolaArea()+"\n");
        System.out.println(foglio[1]);
        System.out.println("Perimetro foglio[1]: "+foglio[1].calcolaPerimetro()+"\nArea foglio[1]: "+foglio[1].calcolaArea()+"\n");
        
        Sfera s1 = new Sfera();
        Sfera s2 = new Sfera("s1 :)) ", 7F);
        System.out.println(s1);
        System.out.println("Area s1: "+s1.calcolaArea()+"\nVolume s1: "+s1.calcolaVolume()+"\n");
        System.out.println(s2);
        System.out.println("Area s2: "+s2.calcolaArea()+"\nVolume s2: "+s2.calcolaVolume());
    }
}
