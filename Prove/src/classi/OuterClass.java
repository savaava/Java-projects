package classi;

public class OuterClass {
    private int a = 333;
    
    public static class StaticNestedClass {
        public static void m(){
            System.out.println("classe statica annidata");
        }
    }
    
    public class InnerClass {
        private int a = 444;
        
        public void m(){
            int a = 555;
            System.out.println("classe interna");
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(OuterClass.this.a);
        }
    }
    
    public void metodo(){
        int a = 222;
        
        class LocalClass {
            private int a = 111;
            
            public void m(){
                System.out.println("classe locale");
                System.out.println(a);
            }
        }
        
        new LocalClass().m(); 
    }
}
