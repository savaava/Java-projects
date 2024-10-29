package interfacce;

public interface InterfacciaMadre {
    public static final int x1 = 0;
    int x2 = 0;
    
    void metodo1();
    
    static void metodoStaticoUno(){
        System.out.println("metodoStaticoUno di InterfacciaMadre");
    }
    
    static void metodo2(){
        System.out.println("metodo2 statico di InterfacciaMadre");
    }
    
    default void metodo3(){
        System.out.println("metodo3 default di InterfacciaMadre");
    }
    
    /* da java 9 
    private String metodo4(){
        return " di InterfacciaMadre";
    }*/
}
