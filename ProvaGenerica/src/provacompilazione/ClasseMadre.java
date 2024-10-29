package provacompilazione;

import java.time.LocalDate;

public class ClasseMadre implements Comparable<ClasseMadre> {
    private final LocalDate data;
    private final int x;
    
    public ClasseMadre(int y, int m, int d,  int x){
        data = LocalDate.of(y,m,d);
        this.x = x;
    }
    
    public LocalDate getData(){
        return data;
    }
    public int getX(){
        return x;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        
        ClasseMadre o = (ClasseMadre)obj;
        return data.equals(o.data);
    }
    
    @Override
    public int compareTo(ClasseMadre o){
        return this.data.compareTo(o.data);
    }
    
    @Override
    public String toString(){
        return "classe -> data="+data+" | x="+x+"\n";
    }
}
