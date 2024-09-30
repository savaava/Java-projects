package lezioni.package1;

public class ClasseDue {
    private final String str;
    
    public ClasseDue(){
        this("NO strings");
    }
    
    public ClasseDue(String str){
        this.str = str;
    }
    
    public void stampaStringa(){
        System.out.println(str);
    }
}
