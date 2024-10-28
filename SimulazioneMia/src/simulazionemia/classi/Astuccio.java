package simulazionemia.classi;

import simulazionemia.exceptions.ProprietarioDiversoException;
import simulazionemia.exceptions.SpazioSaturatoException;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Astuccio {
    private final String proprietario;
    private final int capienzaMassimaOggetti;
    private final List<StrumentoScrittura> astuccio;

    public Astuccio(String proprietario, int capienzaMassimaOggetti) {
        this.proprietario = proprietario;
        this.capienzaMassimaOggetti = capienzaMassimaOggetti;
        astuccio = new ArrayList<>();
    }

    public String getProprietario() {
        return proprietario;
    }
    
    public int getCapienzaMassima(){
        return capienzaMassimaOggetti;
    }
    
    public List<StrumentoScrittura> getAstuccio(){
        return astuccio;
    }

    public void aggiuntaStrumento(StrumentoScrittura s) throws ProprietarioDiversoException, SpazioSaturatoException {        
        if(! s.getProprietario().equalsIgnoreCase(proprietario)) 
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        if(astuccio.size() == capienzaMassimaOggetti) 
            throw new SpazioSaturatoException("SpazioSaturatoException");
        astuccio.add(s);
    }

    public void rimuoviStrumento(StrumentoScrittura s) throws ProprietarioDiversoException {
        if(! s.getProprietario().equalsIgnoreCase(proprietario)) 
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        
        Iterator<StrumentoScrittura> si = astuccio.iterator();
        StrumentoScrittura sTmp;
        while(si.hasNext()){
            sTmp = si.next();
            if(sTmp.getId().equals(s.getId())){
                si.remove();
                return ;
                /* rimuovo solo la prima occorrenza */
            }                
        }
        
        astuccio.remove(s);
    }

    @Override
    public String toString() {
        StringBuffer strb = new StringBuffer("\n------Astuccio di ");
        strb.append(proprietario);
        strb.append("------\nNumero strumenti: ");
        strb.append(astuccio.size());
        strb.append("/");
        strb.append(capienzaMassimaOggetti).append("\n");
        
        for(StrumentoScrittura si : astuccio){
            strb.append(si).append("\n");
        }
        strb.append("------Fine elenco strumenti astuccio------\n");
        
        return strb.toString();
    }
}
