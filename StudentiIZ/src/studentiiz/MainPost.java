package studentiiz;

public class MainPost {
    public static void main(String[] args) {
        /*
        ad esempio una TASTIERA: non si deve creare una classe per ogni bottone -> classe anonima
        */
        
        /*
        applicazione java è un grafo -> grafo della scena (nodo scena radice e avrà
        sotto nodi che sono i vari componenti grafici: pannelli,)
        Anche per la gestione degli eventi che vengono gestiti con una certa politica
        app che ha un'interfaccia grafica -> deve gestire degli eventi scatenati dall'utente che interagisce
        con l'interfaccia -> noi siamo in ascolto degli eventi e una volta catturati eseguo delle procedure
        (pressione di un tasto,...) evento non si genera localmente bensì segue un percorso specifico
        2)ActionEvent -> associo 
        tutti gli elementi dell'interfaccia grafica implementano l'interfaccia EventTarget
        Group può racchiudere più elementi grafici
        la gestione degli eventi : partire dalla radice arriva alla fine
        consumare l'evento a diversi livelli
        i nodi vengono visitati tutti e la gestione dell'evento può essere effettuata a diversi livelli
        
        2 possibilità durante la visita:
        1 fase di cattura si parte dallo stage e si visitano tutti i nodi e in questa fase di discesa
        si cattura l'evento e si può consumare a un certo livello tralasciando quelli sotto 
        se il triangolo è ad esempio disabilitato -> non viene gestito l'evento perchè ci fermiamo prima
        2 in salita non vengono filtrati gli altri nodi perchè vedo quali sono i nodi attivi all'inizio
        
        è sbaglaito pensare che se c'è un pulsante e viene premuto noi eseguiamo direttamente quell'evento
        e quindi ci dobbiamo visitare il grafo capendo ad esempio cosa dobbiamo fare quando clicca col maouse
        (selezione o trascinamento del pannello)
        
        EventHandler -> qual è la procedura 
        
        
        Organizzazione degli elementi grafici:
        i contenitori come il group sono quelle classi che raccolgono più elementi grafici e poi
        disporli sulla scena con una certa  o una certa simmetria , spaziatura
        ci sono dei contenitori che gestiscono automaticamente 
        
        AnchorPane -> 2 pixel dal bordo sinistr, ...
        
        proprietà BINDING nativo sui componenti grafici che consente a oggetti grafici a legarsi 
        in maniera automatica
        ad es voglio che una modifica sul campo di testo anzichè di dover gestire un'azione richiedendo
        all'utente di cliccare un pulsante, voglio che automaticamente cambia la label o qualcos'altro 
        si basa sul meccanismo di osservazione da parte di un componente che ne guarda un'altro 
        
        se io ho una mia label so che è un oggetto e ci sono attributi come una string
        javaFx fa un passo in avanti rispetto a swing e string diventa ora stringa proprerty ed è una stringa
        osservabile. tutti gli oggetti grafici sono osservabili
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
    }
}
