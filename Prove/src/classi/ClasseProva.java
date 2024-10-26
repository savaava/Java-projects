package classi;

import exceptions.NonControllataException;

public class ClasseProva {
    public static void metodoProveEccezione(int x) throws NonControllataException{
        if(x>0)
            throw new NonControllataException("eccezione non controllata!!!!");
        throw new ArithmeticException("ciao sono l'eccezione aritmetica!!!!");
    }
}
