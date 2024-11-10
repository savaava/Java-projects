package prove;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class MainImportStatic {
    public static void main(String[] args) {
        float x = 5.1F, y = 2.4f;
        double out = sqrt(pow(x,2)+pow(y,2));
        out *= PI;
    }
}
