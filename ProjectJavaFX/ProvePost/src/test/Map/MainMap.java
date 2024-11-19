package test.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args) {
        System.out.println("**********HashMap***********\n");
        
        Map<Persona,Integer> elencoMap;
        elencoMap = new HashMap<>();
        
        elencoMap.put(new Persona("Luigi","Rossi","aiduash",34), 11);
        elencoMap.put(new Persona("Li","Ri","aiduash",34), 11);
        elencoMap.put(new Persona("Luigina","Rossella","ccihhhh",20), 88);
        elencoMap.put(new Persona("Luigione","Rossone","bisadaash",10), 5);
        elencoMap.put(new Persona("Luigione","Rossone","IASBDAS",10), 50);
        
        //System.out.println(elencoMap+"\n\n");
        System.out.println(elencoMap.containsKey(new Persona("","","aiduash",0)));
        System.out.println(elencoMap.containsValue(11));
        
        System.out.println("\nSOLI VALUES: ");
        for(Integer valori : elencoMap.values()){
            System.out.println(valori);
        }
        
        System.out.println("\nSOLE KEYS (senza alcun ordine): ");
        for(Persona chiavi : elencoMap.keySet()){
            System.out.println(chiavi);
        }
        
        System.out.println("\nKEYS e VALUES: ");
        Set<Map.Entry<Persona,Integer>> elencoSet;
        elencoSet = elencoMap.entrySet();
        Iterator<Map.Entry<Persona,Integer>> it = elencoSet.iterator();
        while(it.hasNext()){
            Map.Entry<Persona,Integer> dato = it.next();
            System.out.println("chiave <-> valore: "+dato.getKey()+" <-> "+dato.getValue());
        }
        
        System.out.println("\n**********TreeMap***********");
        
        Map<Persona,Integer> elencoOrdinato;
        elencoOrdinato = new TreeMap<>(elencoMap);
        //System.out.println(elencoOrdinato+"\n\n");
        System.out.println("\nSOLE KEYS (ordinate secondo l'ordine naturale di Comparable): ");
        for(Persona chiavi : elencoOrdinato.keySet()){
            System.out.println(chiavi);
        }
        
        Map<Persona,Integer> elencoOrdinato2;
        elencoOrdinato2 = new TreeMap<>(new ComparatoreEta());
        //elencoOrdinato2.putAll(elencoMap);
        elencoOrdinato2.put(new Persona("Luigi","Rossi","aiduash",34), 11);
        elencoOrdinato2.put(new Persona("Li","Ri","aiduash",34), 999);
        elencoOrdinato2.put(new Persona("Luigina","Rossella","bisadaash",20), 88);
        elencoOrdinato2.put(new Persona("Luigione","Rossone","bisadaash",10), 5);
        elencoOrdinato2.put(new Persona("Luigione","Rossone","IASBDAS",10), 5000);
        System.out.println("\nKEYS e VALUES (ordinate secondo l'ordine personalizzato di Comparator): ");
        //System.out.println(elencoOrdinato2+"\n\n");
        Set<Map.Entry<Persona,Integer>> elencoEntrySet = elencoOrdinato2.entrySet();
        Iterator<Map.Entry<Persona,Integer>> it2 = elencoEntrySet.iterator();
        while(it2.hasNext()){
            Map.Entry<Persona,Integer> dato2 = it2.next();
            //System.out.println(dato2);
            System.out.println("chiave <-> valore: "+dato2.getKey()+" <-> "+dato2.getValue());
        }
        
        
        System.out.println("\nKEYS e VALUES (ordinate secondo l'ordine personalizzato di Comparator): ");
        TreeMap<Persona, Integer> elenco = new TreeMap<>(new ComparatoreEta());
        Persona persona1 = new Persona("Mario", "Rossi", "ABC123", 25);
        Persona persona2 = new Persona("Luigi", "Verdi", "XYZ789", 30);
        Persona persona3 = new Persona("Anna", "Bianchi", "DEF456", 25);
        elenco.put(persona1, 100);
        System.out.println(elenco);
        elenco.put(persona2, 200);
        System.out.println(elenco);
        elenco.put(persona3, 300);
        System.out.println(elenco);
        elenco.put(persona1, 500);
        System.out.println(elenco);
        for (Map.Entry<Persona, Integer> entry : elenco.entrySet()) {
            System.out.println(entry.getKey() + " <-> " + entry.getValue());
        }
    }
}
