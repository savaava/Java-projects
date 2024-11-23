package prove;

public class MainGenerico {
    public static void main(String[] args) {
        try{
            try{
                int c = 5/0;
            }catch(ArithmeticException ex){
                System.out.println("sono il try annidato: "+ex.getMessage());
            }
        }catch(Exception ex){
            System.out.println("AIUTOOOOOOOOOO: "+ex.getMessage());
        }
    }
}
