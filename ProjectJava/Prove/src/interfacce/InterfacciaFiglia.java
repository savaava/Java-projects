package interfacce;

public interface InterfacciaFiglia extends InterfacciaMadre {    
    //@Override
    static void metodo2(){
        System.out.println("metodo2 statico di InterfacciaFiglia");
    }
    
    @Override
    default void metodo3(){
        System.out.println("metodo3 default di InterfacciaFiglia");
    }
}
