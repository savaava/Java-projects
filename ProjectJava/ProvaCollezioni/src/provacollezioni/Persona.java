package provacollezioni;

public class Persona implements Comparable<Persona>{
    private final String nome;
    private final Integer id;
    
    public Persona(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public Integer getId() {
        return id;
    }
    
    public static Persona shallowCopy(Persona p){
        return p;
    }
    public static Persona deepCopy(Persona p){
        return new Persona(p.nome,p.id);
    }
    
    @Override
    public int hashCode(){
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != Persona.class) return false;
        
        Persona objPersona = (Persona)obj;
        return objPersona.id.equals(id);
    }
    
    @Override
    public int compareTo(Persona obj){
        return nome.compareToIgnoreCase(obj.nome);
    }
    
    @Override
    public String toString(){
        return "("+nome+"-"+id+")";
    }
}
