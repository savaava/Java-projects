package classi;

public class ClasseBlocchiInizializzazione {
    private static int contStatico;
    
    /* -----Blocco di inizializzazione d'istanza----- */
    {
        System.out.println("è stato istanziato un nuovo oggetto! ");
    }
    
    /* -----Blocco di inizializzazione statico----- */
    static {
        contStatico = 0;
        System.out.println("blocco statico");
    }
    
    public static void method(){
        contStatico++;
        System.out.println("sono il metodo statico "+contStatico);
    }
}
