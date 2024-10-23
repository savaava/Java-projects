package interfacce;

public interface InterfacciaFiglia extends InterfacciaMadre {
    @Override
    void metodo1();
    
    //@Override
    static void metodo2(){
        System.out.println("metodo2 statico dall'interfaccia figlia1");
    }
    
    void metodo3();
}
