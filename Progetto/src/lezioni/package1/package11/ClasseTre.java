package lezioni.package1.package11;

public class ClasseTre {
    private final float gg;
    
    public ClasseTre(){
        this(5.99F);
    }
    
    public ClasseTre(float x){
        this.gg = x;
    }
    
    public void stampaValore(){
        System.out.println(gg);
    }
}
