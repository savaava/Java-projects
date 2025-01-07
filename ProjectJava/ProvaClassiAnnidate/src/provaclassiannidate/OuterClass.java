package provaclassiannidate;

public class OuterClass {
    private String a = "attributo di OuterClass";
    private static String aS = "attributo statico di OuterClass";
    
    static class StaticNestedClass {
        private static String a = "attributo di StaticNestedClass";
        public static void mStatico(){
            System.out.println(aS);
            System.out.println(a);
        }
        public void mNoStatico(){
            System.out.println("metodo non statico di StaticNestedClass");
        }
    }
    
    class InnerClass {
        private String a = "attributo di InnerClass";
        public void m(){
            String a = "attributo di m() di InnerClass";
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(OuterClass.this.a);
        }
    }
    
    public void m1(){
        String a = "attributo di m1() di OuterClass";
        class LocalClass {
            String aa = "attributo di LocalClass";
            public void m(){
                System.out.println(this.aa);
                System.out.println(a);
                System.out.println(OuterClass.this.a);
                aa+=" modifica";
//                a+=" modifica";
            }
        }
        
        new LocalClass().m();
    }
    
    public void m2(){
        String a = "attributo di m2() di OuterClass";
        Runnable t = new Runnable(){
            String aa = "attributo di classe anonima";
            @Override
            public void run(){
                System.out.println(a);
                System.out.println(this.aa);
                System.out.println(OuterClass.this.a);
//                a+=" modifica";
            }
        };
        
        t.run();
    }
    
    public void m3(){
        String a = "attributo di m3() di OuterClass";
        
        Runnable t0 = () -> System.out.println("ciao");
        
        new Thread(() -> {
            String aa = "attributo della funzione lambda";
            System.out.println(this.a);
            System.out.println(aa);
        }).start();
        
        Thread t = new Thread(() -> {
            String aa = "attributo della funzione lambda";
            System.out.println(this.a);
            System.out.println(aa);
        });
    }
}
