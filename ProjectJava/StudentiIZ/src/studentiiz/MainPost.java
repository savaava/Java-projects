package studentiiz;

import java.io.FileInputStream;

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
        
        /* 22_11 Esercitazione + 
        shallow copy -> è la copia dei riferimenti degli oggetti di cui si compone, 
        ma l'oggetto this ha un riferimento diverso rispetto alla nuova copia
        con l'interfaccia cloneable facciamo l'override del metodo
        clone e poi restituiamo una shallow copy (return super.clone()), eccezione controllata 
        deep copy -> ci copiamo tutti i campi e restituiamo l'oggetto
        
        serializzazione ben fatta semplifica la vita:
        realizzare la persistenza di un oggetto -> salvare in maniera serializzata un oggetto
        gli oggetti devono implementare serializable
        vogliamo lo stato corrente dell'oggetto: è una fotografia corrente dell'oggetto
        se abbiamo uno stato preciso possiamo serializzare  
        modificatore transit
        ObjectInputStream al posto di DataInputStream readObject per leggere gli oggetti direttamente
        */
        
        /* 25_11 multithread
        
        */
        
        /* javafx
        
        */
    }
}
