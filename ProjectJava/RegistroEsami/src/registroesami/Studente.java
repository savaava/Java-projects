package registroesami;

public class Studente implements java.io.Serializable, Comparable<Studente> {
    private final String nome;
    private final String cognome;
    private final String matricola;
    
    public Studente(String nome, String cognome, String matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }
    
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getMatricola(){
        return matricola;
    }
    
    @Override
    public int hashCode(){
        return matricola.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        
        Studente objS = (Studente)obj;
        return objS.matricola.equalsIgnoreCase(matricola);
    }
    
    @Override
    public int compareTo(Studente s){
        return matricola.compareToIgnoreCase(s.matricola);
    }
    
    @Override
    public String toString(){
        return "Studente{nome="+nome+", cognome="+cognome+", matricola="+matricola+"}";
    }
}
