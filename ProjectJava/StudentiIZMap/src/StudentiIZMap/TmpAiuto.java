package StudentiIZMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TmpAiuto {
    public static void main(String[] args) {        
        Map<Persona,String> elencoMap;
        elencoMap = new HashMap<>(); // sintassi lecita 
        
        /* popolare l'elenco map: ogni persona ha un solo numero di telefono */
        elencoMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoMap.put(new Persona("Luigina","Rossella","aihhhh",20), "089111138");
        elencoMap.put(new Persona("Luigione","Rossone","aisadaash",10), "089218878");
        /* se diciamo che una persona può avere più numeri allora si può invertire k e V 
        ci sono poche bucket list e poi ognuna possiede molti elementi 
        tutto ricade nello stesso bucket*/
        
        String tel = elencoMap.get(new Persona("","","aiduash",9));
        System.out.println("telefono: "+tel);
        
        System.out.println(elencoMap.toString()+"\n");
        
        Set<Persona> setP = elencoMap.keySet();
        for(Persona p : setP){
            System.out.println(p);
        }
        
        Collection<String> collVal = elencoMap.values();
        for(String st : collVal){
            System.out.println(st);
        }
        
        Set<Map.Entry<Persona,String>> elenco_entrySet = elencoMap.entrySet();
        Iterator<Map.Entry<Persona,String>> it = elenco_entrySet.iterator();
        System.out.println(elenco_entrySet);
        while(it.hasNext()){
            Map.Entry<Persona,String> elem = it.next();
            System.out.println(elem.getKey()+"->"+elem.getValue());
        }
        
        
        
        Map<Persona,String> elencoTreeMap;
        elencoTreeMap = new TreeMap<>();
        
        /* popolare l'elenco map: ogni persona ha un solo numero di telefono */
        elencoTreeMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoTreeMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoTreeMap.put(new Persona("Luigina","Rossella","aihhhh",20), "089111138");
        elencoTreeMap.put(new Persona("Luigione","Rossone","aisadaash",10), "089218878");
        System.out.println("\n\n\n"+elencoTreeMap);
        
        Map<Integer,String> elenco_lhmap;
        elenco_lhmap = new LinkedHashMap<>();
        elenco_lhmap.put(101,"Pippo");
        elenco_lhmap.put(107,"Pluto");
        elenco_lhmap.put(102,"Paperino");
        elenco_lhmap.put(103,"Topolino");
        System.out.println("\n\n"+elenco_lhmap);
        elenco_lhmap.put(102,"aoisudhauihdao");
        elenco_lhmap.remove(103);
        System.out.println("\n"+elenco_lhmap);
        System.out.println(elenco_lhmap.containsKey(102));
        System.out.println(elenco_lhmap.containsKey(103));
        
        /*
        serializzabile significa che può prendere i dati e esportarli su un file 
        transient non è serializzabile
        */
    }
}
