package fattura2;

public class Fattura {
    private int numeroProdottiInseriti;
    private String descrizioneFattura;
    private int idFattura;
    private Prodotto prodVett[];
    
    public Fattura(){
        this("no descrizione fattura", 0, 50);
    }
    
    /**
     * @param descrizioneFattura
     * @param idFattura 
     */
    public Fattura(String descrizioneFattura, int idFattura){
        this(descrizioneFattura, idFattura, 50);
    }
    
    public Fattura(String descrizioneFattura, int idFattura, int numeroProdotti){
        this.descrizioneFattura = descrizioneFattura;
        this.idFattura = idFattura;
        numeroProdottiInseriti = 0;
        prodVett = new Prodotto[numeroProdotti];
        /*non inizializzati quindi riferimenti a null !*/
    }
    
    
    public void inserimentoProdotto(Prodotto prodottoCorrente){
        if(numeroProdottiInseriti == prodVett.length){
            System.err.println("In fattura (id: "+idFattura+") raggiunto massimo numero di prodotti inseriti: "+prodVett.length);
            return;
        }//approccio senza else -> più visibile leggibile
        
        prodVett[numeroProdottiInseriti++] = prodottoCorrente;        
    }
    
    public String getDescrizioneFattura(){
        return descrizioneFattura;
    }
    public void setDescrizioneFattura(String descrizioneFattura){
        this.descrizioneFattura = descrizioneFattura;
    }
    
    public int getIdFattura(){
        return idFattura;
    }
    public void setIdFattura(int idFattura){
        this.idFattura = idFattura;
    }
    
    public void stampaFattura(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Descrizione Fattura: "+descrizioneFattura);
        System.out.println("Id Fattura: "+idFattura);
        System.out.println("Numero prodotti inseriti: "+numeroProdottiInseriti+"/"+prodVett.length);
        for(int i=0;  i<numeroProdottiInseriti;  i++){
            System.out.println("\nProdotto #"+(i+1)+":");
            prodVett[i].stampaProdotto();
        }
        System.out.println("--------------------------------------------------------------------\n");
    }
}
