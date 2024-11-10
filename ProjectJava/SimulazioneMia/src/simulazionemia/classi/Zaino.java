package simulazionemia.classi;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import simulazionemia.exceptions.ProprietarioDiversoException;
import simulazionemia.exceptions.SpazioSaturatoException;

public class Zaino {
    private final String proprietario;
    private final Astuccio astuccio;
    private final Set<Quaderno> quaderni;
    private final int capienzaMassimaOggetti;

    public Zaino(String proprietario, int capienzaMassimaOggetti, Astuccio astuccio) throws ProprietarioDiversoException {
        if(! proprietario.equalsIgnoreCase(astuccio.getProprietario()))
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        this.proprietario = proprietario;
        this.capienzaMassimaOggetti = capienzaMassimaOggetti;
        this.astuccio = astuccio;
        quaderni = new HashSet<>();
    }

    public String getProprietario() {
        return proprietario;
    }

    public int getCapienzaMassimaOggetti() {
        return capienzaMassimaOggetti;
    }

    public void aggiungiQuad(Quaderno q) throws ProprietarioDiversoException, SpazioSaturatoException {
        if(! q.getProprietario().equalsIgnoreCase(proprietario)) 
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        if(quaderni.size()+1 == capienzaMassimaOggetti) 
            throw new SpazioSaturatoException("SpazioSaturatoException");
        quaderni.add(q);
    }

    public void rimuoviQuad(Quaderno q) throws ProprietarioDiversoException {
        if(! q.getProprietario().equalsIgnoreCase(proprietario)) 
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        quaderni.remove(q);
    }
    
    public StrumentoScrittura getFromAstuccio(StrumentoScrittura s) throws ProprietarioDiversoException{
        if(! s.getProprietario().equals(proprietario) ) 
            throw new ProprietarioDiversoException("ProprietarioDiversoException");
        
        Iterator<StrumentoScrittura> ai = astuccio.getAstuccio().iterator();
        StrumentoScrittura sTmp;
        while(ai.hasNext()){
            sTmp = ai.next();
            if(sTmp.getId().equals(s.getId())){
                ai.remove();
                return sTmp;
            }                
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuffer strb = new StringBuffer("------------Zaino di ");
        strb.append(proprietario).append("------------");
        strb.append("------\nNumero oggetti: ");
        strb.append((quaderni.size()+1));
        strb.append("/");
        strb.append(capienzaMassimaOggetti).append("\n");
        
        strb.append(astuccio).append("\n");
        for(Quaderno qi : quaderni){
            strb.append(qi).append("\n");
        }
        strb.append("------------Fine elenco oggetti zaino------------\n");
        
        return strb.toString();
    }
}
