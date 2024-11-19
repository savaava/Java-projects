package tmpaiuto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TmpAiuto {
    public static void main(String[] args) {
        /*
        18_11 Map 
        fanno parte del framework java collection, ma non implementano collection
        bensì Map. Dietro le HashSet c'è HashMap
        3 implementazioni dell'interfaccia Map: hashMap vs linkedHashMap vs TreeMap (ordine)
        si differenziano da come viene gestito l'inserimento:
        1: hashMap dipende dalla chiave
        2: doppiamente linkati
        3: ordine nell'inserimento viene preservato anche in sovrascrittura 
        relazione d'ordine tramite Comparable o comparator
        
        Hashtable è meno efficiente di HashMap e gestisce la sincronizzazione
        mentre HashMap dobbiamo sincronizzare noi 
        
        la kiave caratterizza l'elemento -> possiamo avere tanti omonimi però la chiave potrebbe
        essere la mail o il codice fiscale 
        K -> chiave univoco associato a una persona
        V -> è effettivamente il valore 
        Map.Entry è un'interfaccia interna 
        3 metodi oltre a quelli id inserimento (put e non add) e visita get(kiave):valore:
        keySet(), values(), entrySet()
        containsKey, containsValue 
        
        vogliamo gestire una rubrica con i numeri di telefono delle persone 
        equals e hashCode
        */
        
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
        
        /*
        put(key,value):
        get(key):value
        
        remove(key,value):boolean
        remove(key):value (è utilissima, prove intercorso)
        */
        
        String tel = elencoMap.get(new Persona("","","aiduash",9));
        System.out.println("telefono: "+tel);
        
        System.out.println(elencoMap.toString()+"\n");
        
        /* tale metodo restituisce un set */
        Set<Persona> setP = elencoMap.keySet();
        for(Persona p : setP){ /* ci stampiamo tutte le chiavi */
            System.out.println(p);
        }
        
        /* collezione generica perchè i valori possono essere duplicati metnre key no */
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
        elencoTreeMap = new TreeMap<>(); // sintassi lecita 
        
        /* popolare l'elenco map: ogni persona ha un solo numero di telefono */
        elencoTreeMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoTreeMap.put(new Persona("Luigi","Rossi","aiduash",34), "08921312638");
        elencoTreeMap.put(new Persona("Luigina","Rossella","aihhhh",20), "089111138");
        elencoTreeMap.put(new Persona("Luigione","Rossone","aisadaash",10), "089218878");
        System.out.println("\n\n\n"+elencoTreeMap);
        
        Map<Integer,String> elenco_lhmap;
        elenco_lhmap = new LinkedHashMap<>();
        /* importa l'oridne con cui abbiamo inserito e basta quindi è diverso dagli altri due */
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
