package simulazionedistributorebevande.distributore;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import simulazionedistributorebevande.distributore.eccezioni.*;

public class Distributore {
    private final List<Bibita> bibite;
    private final Set<Tessera> tessere;
    
    public Distributore(){
        bibite = new ArrayList<>();
        tessere = new TreeSet<>();
    }
    
    public void registraTessera(int codice) throws CodiceTesseraPresenteException {
        Tessera tesseraUtente = new Tessera(codice, 0.0);        
        if(tessere.contains(tesseraUtente)) 
            throw new CodiceTesseraPresenteException("C'è già una tessera con questo codice -> non si può registrare!\n");
        
        tessere.add(tesseraUtente); /* no doppioni */
    }    
    public void caricaTessera(int codice, double saldo) throws TesseraNonValidaException {
       Tessera tesseraUtente = new Tessera(codice, saldo);
       if(! tessere.contains(tesseraUtente)) 
           throw new TesseraNonValidaException("la tua tessera ("+codice+") non è registrata!\n");
       
       tessere.remove(tesseraUtente);
       tessere.add(tesseraUtente);
    }
    
    
    public void registraBibita(Bibita b) throws CodiceBibitaPresenteException {
        if(bibite.contains(b)) 
            throw new CodiceBibitaPresenteException("C'è già una bibita con questo codice -> non si può registrare!\n");
        
        bibite.add(b); /* anche se è una lista non avremo doppioni */
    }    
    public void caricaBibita(String codice, int numero) throws BibitaNonPresenteException {
        for(Bibita bi : bibite){
            if(bi.getCodice().equals(codice)){ /* unica occorrenza */
                bi.setNumero(numero + bi.getNumero()); /* aumento il numero di questa bibita */
                return; /* non finiremo qui se non c'è la bibita da caricare */
            }
        }
        throw new BibitaNonPresenteException("La bibita richiesta "+codice+" non è registrata / presente!\n");
    }
    
    
    public void eroga(String codiceBibita, int codiceTessera) 
            throws BibitaNonPresenteException, BibitaEsauritaException, TesseraNonValidaException, CreditoInsufficienteException {
        
        double saldoRimanenteTessera = visualizzaSaldoTessera(codiceTessera);
        int numeroRimanentiBibite = visualizzaBibiteDisponibili(codiceBibita);
        
        if(numeroRimanentiBibite == 0)
            throw new BibitaEsauritaException("BibitaEsauritaException");
        
        Bibita bibitaRichiesta = null;
        for(Bibita bi : bibite){
            if(bi.getCodice().equals(codiceBibita)){
                bibitaRichiesta = bi; /* unica occorrenza */
            }
        }        
        
        if(bibitaRichiesta == null) 
            throw new BibitaNonPresenteException("La bibita richiesta "+codiceBibita+" non è registrata / presente!\n");
        
        if(bibitaRichiesta.getPrezzo() > saldoRimanenteTessera)
            throw new CreditoInsufficienteException("CreditoInsufficienteException");
        
        bibitaRichiesta.setNumero(bibitaRichiesta.getNumero() - 1);
        
        Tessera tesseraUtente = new Tessera(codiceTessera, saldoRimanenteTessera);
        for(Tessera ti : tessere){
            if(ti.equals(tesseraUtente)){
                tesseraUtente = ti;/* troveremo l'unica occorrenza */
            }
        }        
        tesseraUtente.setSaldo(saldoRimanenteTessera - bibitaRichiesta.getPrezzo());
    }
    
    
    public double visualizzaSaldoTessera(int codice) throws TesseraNonValidaException {
        Tessera tesseraUtente = new Tessera(codice, 0.0);
        
        for(Tessera ti : tessere){
            if(ti.equals(tesseraUtente)){
                return ti.getSaldo(); /* troveremo l'unica occorrenza se è presente la tessera */
            }
        }
        throw new TesseraNonValidaException("la tua tessera ("+codice+") non è registrata!\n");
    }
    
    public int visualizzaBibiteDisponibili(String codice) throws BibitaNonPresenteException {
        for(Bibita bi : bibite){
            if(bi.getCodice().equals(codice)){
                return bi.getNumero(); /* se la bibita è presente considereremo l'unica occorrenza */
            }
        }
        throw new BibitaNonPresenteException("La bibita richiesta "+codice+" non è registrata / presente!\n");
    }
    
    
    @Override
    public String toString(){
        String strTmp = "********Distributore********\n***Tessere registrate: "+tessere.size()+"\n";        
        StringBuffer strb = new StringBuffer(strTmp);
        
        for(Tessera ti : tessere){
            strb.append("*").append(ti).append("\n");
        }
        
        strb.append("***Bibite registrate: ").append(bibite.size()).append("\n");
        for(Bibita bi : bibite){
            strb.append("*").append(bi).append("\n");
        }
        
        strb.append("******Fine distributore******\n");
        
        return strb.toString();
    }
}
