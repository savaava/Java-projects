package inf_hiding;

public class Prodotto {
    private int codiceProdotto;
    private String descrizioneProdotto;
    private float costoProdotto;
    
    public Prodotto(int codiceProdotto, String descrizioneProdotto, float costoProdotto){ 
        this.codiceProdotto = codiceProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.costoProdotto = costoProdotto;
    }
    
    private final int x = 1; 
    
    public void setCodiceProdotto(int codiceProdotto){
        this.codiceProdotto = codiceProdotto;
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
    
    public void printProdotto(){
        System.out.println(codiceProdotto);
        System.out.println(descrizioneProdotto);
        System.out.println(costoProdotto);
    }
}
