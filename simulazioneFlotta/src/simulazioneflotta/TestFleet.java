package simulazioneflotta;

// NON MODIFICARE QUESTO FILE
import java.time.LocalDate;

/**
 *
 * @author lucagreco
 */
public class TestFleet {    
    public static void main(String[] args) {     
        
        Fleet f = new Fleet("myFleet");
        
        Truck tractor1 = new Truck("HH245TP", LocalDate.of(2020, 10, 10));
        Truck tractor2 = new Truck("HH247TH", LocalDate.of(2019, 10, 10));
        Truck tractor3 = new Truck("HH237TG", LocalDate.of(2019, 10, 10));
        
        Tanker tanker1 = new Tanker(tractor1, 5000, 3, true);
        Tanker tanker2 = new Tanker(tractor2, 7500, 1, false);
      
       
        f.add(tanker1);
        f.add(tanker2);
        f.add(tractor1);
        f.add(tractor2);
        f.add(tractor3);
        
        System.out.println(f);
        
        try {
        
            Tanker tanker3 = new Tanker(tractor2, 2000, 1, false);
        
        } catch(IllegalArgumentException ex) {
        
        
            System.out.println("\nException test: \n" + ex + "\n");
        
        }
        
        Fleet t = f.filterFoodGrade();
        
        
        System.out.println(t);       
    }    
}

/*
Si chiede di completare il seguente insieme di classi necessarie alla realizzazione di una semplice applicazione per la gestione di una flotta di Camion.
- Truck : implementa l’entità Truck, un camion con pianale libero per trasporto generico. Tiene traccia, mediante attributi in sola lettura, del numero di telaio (String), della data di immatricolazione (LocalDate). Due Truck sono uguali se hanno lo stesso numero di telaio. La relazione di uguaglianza è preservata nelle sottoclassi. Si preveda un costruttore con i parametri necessari a inizializzare  in maniera appropriata lo stato dell'oggetto e i metodi getter per tutti gli attributi.
- Tanker : modella un camion cisterna specializzando Truck. Un Tanker è ottenuto installando una cisterna mono o multicomparto sul pianale: non possono quindi esistere un Truck e un Tanker distinti con lo stesso numero di telaio. Il costruttore può accettare un parametro di tipo Truck da cui ottenere i valori degli attributi relativi a quest'ultimo. La classe Tanker tiene inoltre traccia mediante attributi in sola lettura della capacità totale della cisterna in litri e del numero di compartimenti disponibili. La cisterna può essere classificata food-grade e quindi idonea al trasporto di alimentari (prevedere un attributo di opportuno tipo di dato). La capacità della cisterna può variare da  5000 a 25000 litri.  Il numero di compartimenti massimo previsti per il Tanker è 4.  Se in fase di creazione dell'oggetto Tanker i vincoli sulla capacità totale e/o sul numero di compartimenti non sono soddisfatti è sollevata un'eccezione di tipo IllegalArgumentException con messaggio "Invalid total capacity value or bad compartments number"
- Fleet : modella la flotta di camion come un'aggregazione di Truck. Si scelga una collezione che non consente l'inserimento di più camion con lo stesso numero di telaio. La classe Fleet dovrà prevedere, ovviamente, un metodo che consente di aggiungere un Truck alla flotta. La classe Fleet prevede anche un metodo filterFoodGrade() che consente la creazione di una flotta contenente i soli camion cisterna food-grade a partire dalla flotta iniziale.

Per accedere direttamente alla pagina della documentazione di Java 8 usare il seguente URL:

https://docs.oracle.com/javase/8/docs/api/index.html



Ridefinire per tutte le classi elencate i metodi toString() in modo che l'esecuzione della classe di test fornita "TestFleet" produca il seguente output:

myFleet contains:
[
Truck{chassisID=HH247TH, registrationDate=2019-10-10}->Tanker{totalCapacity=7500, compartments=1, foodGrade=false},
Truck{chassisID=HH237TG, registrationDate=2019-10-10},
Truck{chassisID=HH245TP, registrationDate=2020-10-10}->Tanker{totalCapacity=5000, compartments=3, foodGrade=true}]

Exception test:
java.lang.IllegalArgumentException: Invalid total capacity value or bad compartments number.

myFleet with only food-grade Tankers contains:
[
Truck{chassisID=HH245TP, registrationDate=2020-10-10}->Tanker{totalCapacity=5000, compartments=3, foodGrade=true}]
*/
