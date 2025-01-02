package provacollezioni;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Mario",9987);
        Persona p2 = new Persona("Giggi",2254);
        Persona p3 = new Persona("Marco",1111);
        Persona p4 = new Persona("Andrea",2222);
        Persona p5 = new Persona("Simone",3333);
        Persona p6 = new Persona("Marco",1111);


        List<Persona> l1 = new ArrayList<>();
        l1.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));        
        System.out.println(l1+"(ArrayList)");
        
        List<Persona> l2 = new LinkedList<>();
        l2.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        System.out.println(l2+"(LinkedList)");
        
        System.out.println();
        
        Set<Persona> s1 = new HashSet<>();
        s1.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        System.out.println(s1+"(HashSet)");
        
        Set<Persona> s2 = new LinkedHashSet<>();
        s2.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        System.out.println(s2+"(LinkedHashSet)");
        
        Set<Persona> s3 = new TreeSet<>();
        s3.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        System.out.println(s3+"(TreeSet comparable)");
        
        Set<Persona> s4 = new TreeSet<>(new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getId().compareTo(o2.getId());
            }
        });
        s4.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        System.out.println(s4+"(TreeSet comparator)");
        
        System.out.println();
        
        Map<Integer, Persona> m1 = new HashMap<>();
        m1.put(p1.getId(), p1);
        m1.put(p2.getId(), p2);
        m1.put(p3.getId(), p3);
        m1.put(p4.getId(), p4);
        m1.put(p5.getId(), p5);
        m1.put(p6.getId(), p6);
        System.out.println(m1+"(HashMap)");
        
        Map<Integer, Persona> m2 = new LinkedHashMap<>();
        m2.put(p1.getId(), p1);
        m2.put(p2.getId(), p2);
        m2.put(p3.getId(), p3);
        m2.put(p4.getId(), p4);
        m2.put(p5.getId(), p5);
        m2.put(p6.getId(), p6);
        System.out.println(m2+"(LinkedHashMap)");

        Map<Integer, Persona> m3 = new TreeMap<>();
        m3.put(p1.getId(), p1);
        m3.put(p2.getId(), p2);
        m3.put(p3.getId(), p3);
        m3.put(p4.getId(), p4);
        m3.put(p5.getId(), p5);
//        m3.put(p6.getId(), p6);
        System.out.println(m3+"(TreeMap)");
        System.out.println(m3.containsKey(p6.getId()));
        System.out.println(m3.containsValue(p6));
        System.out.println(m3.values());
        System.out.println(m3.keySet());
        Set<Map.Entry<Integer, Persona>> tmp = m3.entrySet();
        Iterator<Map.Entry<Integer, Persona>> i = tmp.iterator();
        while(i.hasNext()){
            Map.Entry<Integer, Persona> currEntry = i.next();
            System.out.println(currEntry.getKey()+"-->"+currEntry.getValue());
        }
        System.out.println("Con forEach:");
        for(Map.Entry<Integer, Persona> currEntry : m3.entrySet()){
            System.out.println(currEntry.getKey()+"-->"+currEntry.getValue());
        }
    }
}
