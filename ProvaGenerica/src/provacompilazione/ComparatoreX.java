package provacompilazione;

import java.util.Comparator;

public class ComparatoreX implements Comparator<ClasseMadre> {
    @Override
    public int compare(ClasseMadre o1, ClasseMadre o2){
        return o1.getX() - o2.getX();
    }
}
