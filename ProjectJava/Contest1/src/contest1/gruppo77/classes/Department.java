package contest1.gruppo77.classes;

import contest1.gruppo77.comparators.BirthDateComparator;
import contest1.gruppo77.interfaces.Sortable;
import contest1.gruppo77.interfaces.PersonFilter;
import contest1.gruppo77.interfaces.Filterable;
import java.util.List;
import java.util.LinkedList;

public class Department extends LinkedList<Person> implements Sortable, Filterable {
    
    @Override
    public void sort() {
        this.sort(null);
    }
    
//    @Override
//    public void sort() {
//        this.sort(new BirthDateComparator());
//    }
    
//    @Override
//    public void sort() {
//        /* Selection Sort */
//        int imin,j;
//        Person tmp;
//        for(int i=0;  i<this.size()-1;  i++){
//            imin = i;
//            for(j=i;  j<this.size();  j++){
//                if(this.get(j).compareTo(this.get(imin))>0)
//                    imin = j;
//            }
//            tmp = this.get(i);
//            this.set(i,this.get(imin));
//            this.set(imin,tmp);
//        }
//    }
    
    @Override 
    public List<Person> filter(PersonFilter f) {
        List<Person> out = new LinkedList<>();
        for(Person pi : this){
            if(f.checkPerson(pi))
                out.add(pi);
        }
        return out;
    }
    
    @Override
    public String toString() {
        StringBuffer strb = new StringBuffer("Persone nel department:\n");
        for(Person pi : this){
            strb.append(pi).append("\n");
        }        
        return strb.toString();
    }
}