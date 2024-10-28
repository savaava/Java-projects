package interfacce;

public interface InterfacciaMadre {
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
