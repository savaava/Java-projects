package lezioni.package1;

public class ClasseUno {
    private final int c;
    
    public ClasseUno(){
        this(5);
    }
    
    public ClasseUno(int c){
        this.c = c;
    }
    
    private int calcolaValore(){
        return (c<0)? c+10 : c*2;
    }
    
    public void stampaValore(){
        int val = calcolaValore();
        System.out.println(val);
    }
}
