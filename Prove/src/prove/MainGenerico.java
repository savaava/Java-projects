package prove;

import classi.ClasseFiglia1;
import classi.ClasseMadre;
import classi.ClasseBlocchiInizializzazione;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class MainGenerico {
    public static void main(String[] args) {
        float x = 5.1F, y = 2.4f;
        double out = sqrt(pow(x,2)+pow(y,2));
        out *= PI;
        System.out.println(out+"\n");
        
//        ClasseMadre o1 = new ClasseFiglia1();
//        o1.metodo4();
//        
//        ClasseMadre o2 = new ClasseFiglia1();
//        o2.metodo5(333);
        
        System.out.println("\n");
        
        ClasseBlocchiInizializzazione.method();
        ClasseBlocchiInizializzazione.method();
        ClasseBlocchiInizializzazione.method();
        ClasseBlocchiInizializzazione o = new ClasseBlocchiInizializzazione();
    }
}
