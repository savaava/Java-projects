package javaapplication1;

public class Prodotto {    
    private final int codiceProdotto;
    private String descrizioneProdotto;
    private float costoProdotto;
    private static int conteggioProdotti = 0;
    
    /*overloading dei METODI in generale, perchè si possono avere più implementazioni del costruttore, o 
    di metodi, però il costruttore non ha il tipo di ritorno. 2 implementazioni di un metodo 
    che hanno lo stesso numero di parametri e lo stesso tipo allora il tipo di ritorno 
    non entra in gioco per DISTINGUERE I METODI.*/
    public Prodotto() {
        this(0,"prodotto vuoto",0F);
    }
    
    public Prodotto(int codiceProdotto) {
        this(codiceProdotto, "prodotto vuoto", 0F);
    }
    
    public Prodotto(float costoProdotto){
        this(0,"prodotto vuoto", costoProdotto);
    }
    
    public Prodotto(String descrizioneProdotto){
        this(0,descrizioneProdotto,0F);
    }
    
    public Prodotto(int codiceProdotto, String descrizioneProdotto, float costoProdotto){ 
        this.codiceProdotto = codiceProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.costoProdotto = costoProdotto;
        conteggioProdotti++;
    }
    
    public void setDescrizioneProdotto(String descrizioneProdotto){
        this.descrizioneProdotto = descrizioneProdotto;
    }
    
    public void setCostoProdotto(float costoProdotto){
        this.costoProdotto = costoProdotto;
    }
    
    public int getCodiceProdotto(){
        return codiceProdotto;
    }
    
    public String getdescrizioneProdotto(){
        return descrizioneProdotto;
    }
    
    public float getcostoProdotto(){
        return costoProdotto;
    }
    
    public static void raddoppiaConteggioProdotti(){
        conteggioProdotti*=2;
    }
    
    public static int getConteggioProdotti(){
        return conteggioProdotti;
    }
    
    public void printProdotto(){
        System.out.println("codice: "+codiceProdotto);
        System.out.println("descrizione: "+descrizioneProdotto);
        System.out.println("costo: "+costoProdotto);
        System.out.println("conteggio: "+conteggioProdotti);
    }
}
