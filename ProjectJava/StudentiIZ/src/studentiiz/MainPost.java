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
        completiamo il discorso su IO:
        salvataggio o recupero conservata come flusso di caratteri
        per i caratteri è più difficile
        lettura e scrittura binaria separate 
        ulteriori 2 classi astratte: reader e writer per i caratteri 
        Reader classe di partenza e vogliamo il pattern di decorazione
        per i flussi testuali, 
        reader è iuna classe astratta -> c'è il metodo read ma c'è un read astratto
        BufferedReader è un decoratore serve per fare readLine
        InputStreamReader
        is a bridge: da un flusso di byte a un flusso di cartatteri 
        readLine: leggiamo per linee e possiamo dividere la stringa in sottostringhe 
        (token) file csv 
        FileReader è un componente concreto
        
        PrintWriter -> println
        
        Scanner
        hasNext per vedere se c'è il token successivo 
        si ha una stringa lunga a piacere e parto con la scansione con un iteratore
        next restituisce la stringa 
        nextFloat può lanciare un'eccezione perchè se c'è una stringa non convertibile in Float
        InputMismatchException
        la prima cosa è specificare il delimitatore: di default è lo spazio bianco
        con il metodo useDelimiter
            
        
        quindi scrittura di file di testo con Writer e PrintWriter
        
        e lettura con bufferedReader -> prendo un testo e voglio recuperare tutte le parole
        e vorrei selezionare tutte le parole prima devo salvare tutto il file in una maxistringa complessiva
        poi readLine e poi metodo split e scorrere tutte le linee, 
        mentre con lo scanner recupero il flusso un pò per volta anzichè split
        BufferedReader mi consente due comoprtamenti: lettura di linea o di carattere
        
        poi lettura con scanner 
        next 
        posso prendere un pezzo per volta e poi uso lo scanner per ognuno quando ho un file molto grande e
        non so dove finisce 
        
        
        ESERCIZIO: new FileCUser per javaFX metodo .show() -> appare come finestra di dialogo
        nell'esercizio della lista osservabile con gli studenti salvare gli studenti in un file e 
        poi anche lettura da un file con filecuser, partendo da il menù a tendina con open e save
        */
        
        /* 27_11 javafx
        
        */
    }
}
