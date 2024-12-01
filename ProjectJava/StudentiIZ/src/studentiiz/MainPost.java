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
        i thread di 2 tipi:
        1) thread ausiliari subordinati -> se arrestiamo il thread principale si arrestano anche questi demon thread
        quindi dipendono dal principale
        setDaemon a on (di default) per dire che è un thread subordinato
        2) 
        
        il mutex è sempre associato ad una CLASSE, questo è una ltro motivo per cui è utile la classe wrapper
        perchè il tipo primitivo intero non può avere un mutex, ma una classe Int si.
        synchronized ha bisogno di un oggetto e il suo argomento può essere this 
        questa parola chiave dice che le istruzioni presenti nel blocco prevedono l'acquisizione del mutex
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
 