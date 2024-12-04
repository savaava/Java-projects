package gestioneesamiio;

import java.io.Serializable;
import java.time.LocalDate;

public class EsameSuperato implements Comparable<EsameSuperato>, Serializable{
    public static int contaEsami = 0;
    
    private final String matricolaStudente;
    private final LocalDate dataSuperamento;
    private final String nomeEsame;
    private final double voto;
    private final int id;

    public EsameSuperato(String matricolaStudente, LocalDate dataSuperamento, String nomeEsame, double voto) {
        this.matricolaStudente = matricolaStudente;
        this.dataSuperamento = dataSuperamento;
        this.nomeEsame = nomeEsame;
        this.voto = voto;
        id = ++contaEsami;
    }

    public String getMatricolaStudente() {
        return matricolaStudente;
    }

    public LocalDate getDataSuperamento() {
        return dataSuperamento;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }

    public double getVoto() {
        return voto;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != EsameSuperato.class)
            return false;
        
        EsameSuperato o = (EsameSuperato)obj;
        return o.id == id;
    }
    
    @Override
    public int compareTo(EsameSuperato o){
        return id - o.id;
    }
    
    @Override
    public String toString(){
        return "\n*EsameSuperato*"
                +"\nmatricola="+matricolaStudente
                +"\ndataSuperamento="+dataSuperamento
                +"\nnomeEsame="+nomeEsame
                +"\nvoto="+voto;
    }
}
