package studentiiz;

public class MainPost {
    public static void main(String[] args) {
        /*
        una proprietà di tipo intero: è una classe di tipo intero e può partecipare a una relazione, un
        binding matematico  total non viene calcolato una sola volta quanod modficio uno degli operandi
        nume1 2 3 4 allora viene eseguito il calcolo ed esce che total è cambiato
        (devo vedere se la mail inserita è valida -> non devono richiedere opearzioni all'utente deve essere usabile 
        e quindi automatico) non c'è molto codice con binging di javaFx.
        operazioni numeriche, logiche, possono essere gestite in maniera binding
        */
        
        /*
        08_11
        C'è un problema a lvl computazionale col binding perchè analizza sempre le proprietà
        ottica di ottimizzaione
        binding complessi -> valutare pigra: se io ho un'espressione con n osservabili
        la valuitazione viene fatta solo se uso il risultato.
        pigra perchè l'espressione viene valutata solo se uso il risultato
        quello che il sistema vede è la vecchia valutazione
        ci basta gestire un evento con un handler
        */        
        
        /*
        13_11
        una classe che ha come obiettivo quello di caricare tutti gli oggetti grafici dal file ti test
        e li istanzia e li espone sul controller.
        Con uno strumento grafico riusciamo a impostare la vista, viene caricato in maniera dinamica
        possiamo modificare la vista con scene builder e quindi si modifica il file fxml e mantenendo i riferimenti
        è tutto sincronizzato
        tamplete java ant -> java FXML
        */
        
        /* 22_11 
        shallow copy -> è la copia dei riferimenti degli oggetti di cui si compone, 
        ma l'oggetto this ha un riferimento diverso rispetto alla nuova copia
        con l'interfaccia cloneable facciamo l'override del metodo
        clone e poi restituiamo una shallow copy (return super.clone()), eccezione controllata 
        deep copy -> ci copiamo tutti i campi e restituiamo l'oggetto
        */
        
        /* 25_11
        */
        
        /* 27_11 thread
        all'interno dello stesso processo: più flussi di esecuzione, anche per risolvere problemi
        che vengono eseguiti in maniera "contemporanea" 
        vantaggi: se non ci sono dei vantaggi
        se l'operazione B non dipende da A, ossia che usa i dati prodotti da A, allora si può associragli
        un altro thread 
        slide page 7 le operazioni non avvengono effettivamente in parallelo: se ho un processore multicore
        o più processori potrei eseguire perfettamente in parallelo.
        Mentre non avendo multicore allora si eseguono dei pezzi dell'operazione e di conseguenza
        c'è il cambiamento di contesto che occupa tempo
        le operazioni di IO sono le più complesse, quindi se io utilizzassi più thread per un'applicazione
        con UI allora questa è più reattiva quindi non si blocca come avverrebbe in maniera sequenziale,
        perchè le operazioni di IO sono complesse e lente.
        Quindi queste operazioni che richiedono molta complessità computazionale, elaborazione d'immagini
        allora conviene associare queste operazioni a dei thread.
        Quindi questo approccio multithreading è una necessità 
        
        LE RISORSE SONO CONDIVISE e questo è un vantaggio, lo svantaggio è sempre il context switch
        1° problema: sincronizzazione
        2° problema: attesa
        più flussi di esecuzione che potrebbero accedere simultaneamente ad una risorsa per evitare di 
        generare degli stati incoerenti O inconsistenze
        poichè le operazioni non vengono mai svolte in maniera atomica ci saranno degli accessi non regolamentati
        alle risorse condivise (saldo) e quindi ci sono dei conflitti
        -> mutex = mutua esclusione viene usato in java, è una sirta di flag (libero o impegnato) Tutte le classi
        hanno un attributo nascosto che rappresenta questo flag. 
        Il mutex non viene automaticamente gestito -> dobbiamo bloccare la risorsa manualmente se la sto usando
        Quindi sono i thread che devono acquisire i mutex in due modi:
        1) è la risorsa che è progettata in modo che obbligo i thread ad acquisire il mutex
        2) la risorsa è già fornita e non è thread safe e per l'accesso regolamentato, risolra è libera da vincoli 
           ma devo progettare i thread che accedono alla risorsa in maniera
        se ci sono molti casi in cui c'è dipendenza dei dati allora la gestione dei mutex e controllo dell'accesso
        alle risorse allora potrebbe non convenire più il multithreading rispetto ad un approccio sequenziale
        
        sincronizzazione: acquisizione e rilascio dei mutex e utilizzo delle risorse 
        
        in Java ci sono delle librerie standard per operazioni multithreaing: classe Thread
        se io voglio che parte del main venga gestito da un altro thread allora devo trovare il modo di passargli
        il codice
        creo una classe che estende Thread e il
        metodo run di cui fare l'override e ciò che si specifica in tale metodo sta nel thread
        classe implements Runnable per poter passare tale classe al costruttore della classe Thread
        
        i thread di 2 tipi:
        1) thread ausiliari subordinati -> se arrestiamo il thread principale si arrestano anche questi demon thread
        quindi dipendono dal principale
        setDaemon a on (di default) per dire che è un thread subordinato
        2) 
        
        il mutex è sempre associato ad una CLASSE, questo è una ltro motivo per cui è utile la classe wrapper
        perchè il tipo primitivo intero non può avere un mutex, ma una classe Int si.
        synchronized ha bisogno di un oggetto e il suo argomento può essere this 
        questa parola chiave dice che le istruzioni presenti nel blocco prevedono l'acquisizione del mutex
        
        quando il thread 
        */
        
        /* 29_11
        un thread aspetta che l'altro produce il dato: produttore consumatore
        in questo caso l'incapsulamento è ancora più importante perchè qualsiasi thread potrebbe accedere 
        agli attributi non incapsulati
        
        problematica dell'attesa:
        fino a mo thread interagiscono sulla risorsa senza tenere conto dello stato della risorsa
        intercettare quando un thread ha terminato la sua esecuzione, una notifica di quando la risorsa è
        stata modificata 
        sleep -> il thread non è più attivo è sospeso e il processore può usare le proprie risorse 
        per altre istruzioni però non rilascia il mutex se dovesse averlo acquisito prima!!
        in questo caso l'attesa è fuori dalle operazioni che prevedono l'acquisizione del mutex, così è libera
        la risorsa.
        attesa attiva (sempre sconsiglabile) perchè il processore sta comunque controllando 
        la condizione e si dovrebbe quindi sospendere l'esecuzione e ricevere una notifica di quando può continuare
        
        metodo join per intercettare il completamento dell'esecuzione di un thread, il thread principale 
        quando vede join -> aspetta che il thread su cui è stato invocato il metodo join finisca
        rispetto al thread principale la join diventa bloccante, quindi dobbiamo trovare una condizione di 
        terminazione del thread
        allora join può servire perchè vogliamo aspettare prima che un thread faccia le sue operazioni e poi il
        thread principale continua
        
        buffer risorsa condivisa e i thread che hanno lavori differenti produzione e consumazione
        1 o più thread che consumano e prelevano 
        accedo alla risorsa, vedo se il dato è disponibile, se non  è allora rilascio il mutex mi serve quindi
        un meccanismo che mi risvegli quando è pronta la risorsa che è aggiornata o aggiunta
        2 meccanismi: 
        1 per sospendere l'esecuzione e rilasciare
        2 per risvegliarmi 
        il thread verifica la condizione e se non rispetta le sue esigenze allora si addormenta e viene risvegliato
        quando quella condizione è verificata (no attesa attiva)
        metodi: wait e notifyAll
        wait: thread sospende la propria esecuzione e rilascia il mutex che aveva acquisito, fino a quando un 
        altro thread invoca notifyAll per sbloccare il thread che era in wait e riceve questa notifica e 
        controlla la condizione e poi acquisisce il mutex.
        notifyAll -> risveglia tutti i thread che erano in attesa (con wait) su quella risorsa (obj) e uno 
        dei thread acquisisce il mutex (il primo) 
        anche qui si può gestire dal lato dei thread o dal lato della risorsa
        la condizione deve essere fatta in un ciclo perchè il thread ottiene il mutex perchè un altro thread ha
        invocato notifyAll ma deve verificare che può effettivamente continuare, e quindi deve ricontrollare 
        la condizione e se non è soddisfatta allora invoca di nuovo la wait e rilascia il mutex
        */        
    }
}
 