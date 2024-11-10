package classi.gerarchia;

import classi.gerarchia.ClasseMadre;

public class ClasseFiglia1 extends ClasseMadre {
    public static void metodo2(){
        System.out.println("metodo2 statico di ClasseFiglia1");
    }
    
    /* E' UN OVERRIDE */
    @Override
    public ClasseFiglia1 metodo4(){
        System.out.println("ridefinizione classe figlia");
        return new ClasseFiglia1();
    }
    
    /* E' UN OVERRIDE */
    @Override
    public void metodo5(int param){
        System.out.println("ridefinizione classe figlia");
    }
    
    /* NON E' UN OVERRIDE */
    public void metodo6(ClasseFiglia1 o){
        System.out.println("ridefinizione classe figlia");
    }
    
    /* E' UN OVERRIDE */
    @Override
    public void metodo7(){
        System.out.println("ridefinizione classe figlia");
    }
    
    /* NON E' UN OVERRIDE */
    public void metodo8(){
        System.out.println("ridefinizione classe figlia");
    }
}
