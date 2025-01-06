package gestioneesamisimulazione;

import java.time.LocalDate;

public class EsameSuperato implements Comparable<EsameSuperato>, java.io.Serializable{
    private final String matricolaStudente;
    private final LocalDate data;
    private final String nomeInsegnamento;
    private final int voto;
    
    private final int id;
    private static int cont = 0;
    
    public EsameSuperato(String matricolaStudente, LocalDate data, String nomeInsegnamento, int voto){
        this.matricolaStudente = matricolaStudente;
        this.data = data;
        this.nomeInsegnamento = nomeInsegnamento;
        this.voto = voto;
        id = ++cont;
    }
    
    public String getMatricolaStudente(){
        return matricolaStudente;
    }
    public LocalDate getData(){
        return data;
    }
    public String getNomeInsegnamento(){
        return nomeInsegnamento;
    }
    public int getVoto(){
        return voto;
    }
    
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        
        EsameSuperato objEsame = (EsameSuperato)obj;
        return objEsame.id==id;
    }
    
    @Override
    public int compareTo(EsameSuperato e){
        return Integer.compare(id,e.id);
    }
    
    @Override
    public String toString(){
        return "\n*EsameSuperato*\nmatricola="+matricolaStudente
                +"\ndataSuperamento="+data
                +"\nnomeEsame="+nomeInsegnamento
                +"\nvoto="+voto;
    }
}
