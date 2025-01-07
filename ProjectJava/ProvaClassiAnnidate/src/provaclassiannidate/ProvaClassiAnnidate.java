package provaclassiannidate;

public class ProvaClassiAnnidate {    
    public static void main(String[] args) {
        OuterClass.StaticNestedClass.mStatico();
        OuterClass.StaticNestedClass o1 = new OuterClass.StaticNestedClass();
        
        System.out.println();
        
        OuterClass.InnerClass o2 = new OuterClass().new InnerClass();
        new OuterClass().new InnerClass().m();
        
        System.out.println();
        
        new OuterClass().m1();
        
        System.out.println();
        
        new OuterClass().m2();
        
        System.out.println();
        
        new OuterClass().m3();
    }
}
