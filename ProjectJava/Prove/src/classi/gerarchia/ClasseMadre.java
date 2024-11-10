package classi.gerarchia;

import interfacce.InterfacciaFiglia;
import interfacce.InterfacciaMadre;

public class ClasseMadre implements InterfacciaMadre,InterfacciaFiglia {
    @Override
    public void metodo1(){
        System.out.println("metodo1 ereditato da InterfacciaMadre");
    }
      
    public static void metodo2(){
        System.out.println("metodo2 statico di ClasseMadre");
    }
    
    @Override
    public void metodo3(){
        System.out.println("metodo3 default -> public ereditato da InterfacciaMadre");
    }
    
    public ClasseMadre metodo4(){
        System.out.println("originale classe madre");
        return null;
    }
    
    public void metodo5(int parametro){
        System.out.println("originale classe madre");
    }
    
    public void metodo6(ClasseMadre o){
        System.out.println("originale classe madre");
    }
    
    void metodo7(){
        System.out.println("originale classe madre");
    }
    
    private void metodo8(){
        System.out.println("originale classe madre");
    }
}
