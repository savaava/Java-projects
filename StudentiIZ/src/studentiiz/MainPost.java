package studentiiz;

public class MainPost {
    public static void main(String[] args) {
        /*
        04_11        
        Nested classes
        all'interno del blocco di una classe, ulteriori classi
        all'interno del contesto: classe interna o innestata,
        il posizionamento influenza il comportamento -> infatti
        dobbiamo farlo in una parte specifica:
        1) classi interne non statiche
        2) classi statiche innestate
        
        spazio relativo agli attributi fuori dai metodi posso definire 1) o 2)
        
        ha senso che una classe interna non sia solo public -> private, protected, package
        quindi si può usare esternamente come un attributo quando usiamo package o protected
        
        sono utili perchè 3 motivi: 
        un modo per raggruppare classi in un unico posto che soddisfano delle esigenze
        per incapsulamento -> nascondere l'esistenza della classe all'esterno per una
        migliore leggibilità del codice (necessità di nascondere quella classe per non esporla)
        leggibile e manutenibile -> modifico solo internamente alla classe privata senza influenzare 
        ulteriormente altre classi che eventualmente la usano 
        
        2) per le classi statiche si ha la stessa sintassi -> per prendere un membro di una
        classe statica devo usare il nome della classeesterna.nomedellaclassestatica e poi 
        faccio quello che devo fare 
        può essere istanziata anche se quella esterna non è istanziata, perchè è static e quindi
        possiamo richiamare il costruttore della classe statica come richiamiamo normalmente un 
        metodo statico
        
        1) le classi propriamente interne non posso istanziarle invece senza istanziare prima la classe 
        esterna:
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        
        Shaadowing -> posso avere attribbuti con lo stesso nome -> devo avere un metodo per disambiguare
        come faccio a riferirmi all'attributo della inner class o alla out class 
        (se uso solo il nome si prende )
        
        se uso public -> significa solo un vantaggio di visibilità logica ed è semplicemente più
        interna al suo scopo
        spesso infatti si usa la classe innestata privata per favorire l'incapsulamento
        
        altre 2 tipologie:
        3) classi locali
        4) classi anonime
        
        non sono statiche
        3) vengono definite all'interno dei metodi oppure nello spazio dei parametri
        sono definiti all'interno dei blocchi (in generale all'interno dei metodi)
        per definizione non possono essere accessibili dall'esterno dei metodi 
        quindi il metodo istanzia l'oggetto e poi non esiste più
        la classe può essere usata solo all'interno del metodo, visibilità e operato confinato
        all'esecuzione del metodo quindi (caricata in memoria quando viene eseguito il metodo ogni volta)
        ATTENZIONE gli attributi del metodi non sono modificabili all'interno della classe locale, 
        hanno visibilità delle variabili ma sono intese come costanti -> il loro valore non deve essere
        modificato (meccanismo di protezione) se al posto di c c'è un oggetto io posso accedervi perchè
        è semplicemente un riferimento -> il riferimento è COSTANTE e non significa che non posso modificare
        le cose coi metodi (già lo sapevamo: private final Set<Evento> eventi)
        si può ridefinire l'attributo e c=5 non esiste più per la classe locale
        si possono mettere tutti i modificatori di visibilità ma rimane comunque confinata al metodo
        noto che ha più senso usare una classe anonima (è il predecessore della classe anonima)

        4) definite in linea e istanziare subito -> non c'è bisogno di dare un nome
        alla classe perchè la usiamo solo una volta (devo usare quel metodo solo per quel caso)
        ai metodi non si possono passare le funzioni -> quindi a un metodo in java si passa
        un oggetto con quel metodo, però ci sono altre cose di quella classe e le classi anonime
        vengono usate proprio per specificare un comportamento da usare senza istanziare la classe
        per il comparatore abbiamo definito un oggetot comparatore con l'interfaccia comparator al posto
        dell'ordine naturale, però anzichè fare tanti comparatori diversi uno per nome uno per età uno per 
        data, allora io ho bisogno di una classe anonima senza nome e all'interno del tree set richiamo 
        il nome dell'interfaccia che deve essere implementata
        utile quando non mi serve istanziare troppe volte e quindi (per ) non siamo obbligati ma 
        è un discorso di progettazione.        
        è contraddizione concettuale una classe non dovrebbe essere chiamata
        istanziata solo una volta perchè modella un entità che verrà usata più volte 
        ad esempio una TASTIERA: non si deve creare una classe per ogni bottone -> classe anonima
        
        Stiamo implementando l'interfaccia anche se normalmente dovrei definire una classe che implementa un
        interfaccia 
        elenco,sort(new Comparator<String>(){
            @Overr...
        });
        */
    }
}
