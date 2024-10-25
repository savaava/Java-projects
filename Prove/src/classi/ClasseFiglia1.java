package classi;

public class ClasseFiglia1 extends ClasseMadre {
    public static void metodo2(){
        System.out.println("metodo2 statico di ClasseFiglia1");
    }
    
    @Override
    public ClasseFiglia1 metodo4(){
        return new ClasseFiglia1();
    }
}
