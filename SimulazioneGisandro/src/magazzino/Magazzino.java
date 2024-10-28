package magazzino;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Iterator;

public class Magazzino {
    private final String id;
    private String nome;
    private final Set<Scorta> inventario;
    
    public Magazzino(String id, String nome){
        this.id = id;
        this.nome = nome;
        inventario = new HashSet<>();
    }
    
    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void aggiungiScorta(Prodotto p, int quantita, LocalDate dataAggiornamento) 
            throws ScortaGiaPresenteException, QuantitaNegativaException {
        
        Scorta scortaTmp = new Scorta(p, quantita, dataAggiornamento);
        if(inventario.contains(scortaTmp)) throw new ScortaGiaPresenteException("ScortaGiaPresenteException");
        inventario.add(scortaTmp);
    }
    
//    public void rimuoviScorta(String prodottoId, int quantita, LocalDate dataAggiornamento) 
//            throws QuantitaNonDisponibileException, QuantitaNegativaException, ScortaNonTrovataException, PrezzoNegativoException {
//        
//        if(quantita < 0) throw new QuantitaNegativaException("QuantitaNegativaException");
//        
//        Iterator<Scorta> inventarioIt = inventario.iterator();
//        Scorta scortaTmp;
//        Prodotto prodottoTmp = new Prodotto(prodottoId, "", 0); /* prodotto da cercare */
//        int quantitaRimanente;
//        
//        while(inventarioIt.hasNext()){
//            scortaTmp = inventarioIt.next();
//            if( scortaTmp.getProdotto().equals(prodottoTmp) ){
//                /* trovato l'unico prodotto (se esiste) nell'inventario */
//                quantitaRimanente = scortaTmp.getQuantitaDisponibile() - quantita;
//                if(quantitaRimanente == 0){
//                    /* se non sono rimasti più prodotti in questa scorta -> la rimuovo*/
//                    inventarioIt.remove();
//                }else if(quantitaRimanente > 0){
//                    /* se sono rimasti altri prodotti in questa scorta -> non la rimuovo */
//                    scortaTmp.setQuantitaDisponibile(quantitaRimanente);
//                    scortaTmp.setDataUltimoAggiornamento(dataAggiornamento);
//                }else{ 
//                    /* quantitaRimanente < 0 quindi sono stati richiesti più prodotti di quanti ce ne sono nella scorta di quel prodotto */
//                    throw new QuantitaNonDisponibileException("QuantitaNonDisponibileException");
//                }                
//                return;
//            }
//        }
//        /* significa che la scorta non è stata trovata */
//        throw new ScortaNonTrovataException("ScortaNonTrovataException");
//    }
    
    public void rimuoviScorta(String prodottoId, int quantita, LocalDate dataAggiornamento)
            throws QuantitaNonDisponibileException, QuantitaNegativaException, ScortaNonTrovataException, PrezzoNegativoException {
        
        if(quantita < 0) 
            throw new QuantitaNegativaException("QuantitaNegativaException");
        
        Scorta scortaTmp = this.getScorta(prodottoId);
        
        /* è stato richiesto un numero di prodotti maggiore rispetto a quanti ce ne sono nella scorta */
        if(scortaTmp.getQuantitaDisponibile() < quantita) 
            throw new QuantitaNonDisponibileException("QuantitaNonDisponibileException");
        
        /* rimangono ancora dei prodotti di quella scorta */
        if(scortaTmp.getQuantitaDisponibile() > quantita){
            scortaTmp.setQuantitaDisponibile(scortaTmp.getQuantitaDisponibile() - quantita);
            scortaTmp.setDataUltimoAggiornamento(dataAggiornamento);
            return;
        }
        
        /* finiscono tutti i prodotti disponibili di quella scorta */
        this.inventario.remove(scortaTmp);            
    }
    
    public Scorta getScorta(String prodottoId) 
            throws ScortaNonTrovataException, PrezzoNegativoException {
        
        Prodotto prodottoTmp = new Prodotto(prodottoId, "", 0); /* prodotto da cercare */
        
        for(Scorta si : inventario){
            if(si.getProdotto().equals(prodottoTmp))
                return si;
        }        
        throw new ScortaNonTrovataException("ScortaNonTrovataException");
    }
    
    
    @Override
    public String toString(){
        StringBuffer strb = new StringBuffer("\n-----------------------------------------------------\n");
        
        strb.append("Magazzino ").append(nome).append(" ").append(id).append(" - Elenco scorte\n");
        strb.append("-----------------------------------------------------\n");
        for(Scorta si : inventario){
            strb.append(si).append("\n");
        }
        
        strb.append("Fine elenco\n");
        return strb.toString();
    } 
}
