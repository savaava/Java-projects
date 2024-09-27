package fattura2;

public class Prodotto {
    private int codiceProdotto;
    private String descrizioneProdotto;
    private float costoProdotto;
    
    public Prodotto(){
        this(0, "no prodotto", 0F);
    }
    
    public Prodotto(int codiceProdotto){
        this(codiceProdotto, "no descrizionne prodotto", 0F);
    }
    
    public Prodotto(String descrizioneProdotto){
        this(0, descrizioneProdotto, 0F);
    }
    
    public Prodotto(float costoProdotto){
        this(0, "no descrizione prodotto", costoProdotto);
    }
    
    public Prodotto(String descrizioneProdotto, float costoProdotto){
        this(0, descrizioneProdotto, costoProdotto);
    }
    
    public Prodotto(int codiceProdotto, String descrizioneProdotto, float costoProdotto){
        this.codiceProdotto = codiceProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.costoProdotto = costoProdotto;
    }
    
    public int getCodiceProdotto(){
        return codiceProdotto;
    }
    public void setCodiceProdotto(int codiceProdotto){
        this.codiceProdotto = codiceProdotto;
    }
    
    public String getDescrizioneProdotto(){
        return descrizioneProdotto;
    }
    public void setDescrizioneProdotto(String descrizioneProdotto){
        this.descrizioneProdotto = descrizioneProdotto;
    }
    
    public float getCostoProdotto(){
        return costoProdotto;
    }
    public void setCostoProdotto(float costoProdotto){
        this.costoProdotto = costoProdotto;
    }
    
    public void stampaProdotto(){
        System.out.println("Codice: "+codiceProdotto);
        System.out.println("Descrizione: "+descrizioneProdotto);
        System.out.println("Costo: "+costoProdotto);
    }
}
