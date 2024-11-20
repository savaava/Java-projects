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
        
        
        
        /* 18_11 Map */
        
        /* 20_11 InOut
            This lesson covers the Java platform classes used for basic I/O. 
        It first focuses on I/O Streams, a powerful concept that greatly simplifies 
        I/O operations. The lesson also looks at serialization, which lets a program 
        write whole objects out to streams and read them back again. Then the lesson 
        looks at file I/O and file system operations, including random access files.
        
        per scrivere su un file devono scrivere da uno stream di in o scrivere su uno stream di out
        lettura scrittura da stream binari
        saper leggere da qualsiasi sorgente (di rete) un file binario
        
        partiamo da due classi fondamentali: 
        input.Stream (per un problema di lettura)
        l'unico metodo astratto è il metodo read -> legge il prossimo byte da una sorgente di stream
        specializzare questa classe astratta 
        una volta che ne so leggere uno posso leggerne di più: l'overloading funziona solo quando 
        concretizzo read() altrimenti le altre due read non funzionerebbero
        Classe per leggere da file: FileInputStream
        abbiamo un'implementazione concreta di read() 
        FileInputStream (identifica la sorgente concreta da dove arriva il file input)
        lo posso ereditare extends per aggiungere funzionalità
        DataFileInputStream (interpreto l'intero), URLInputStream, però aggiungiamo sempre una sola 
        funzionalità come lettura bufferrizzata dalla classe BufferedInputStream però ci vogliono
        molte specializzazioni -> non è conveniente quindi si adotta una strategia diversa il pattern
        si chiama di decorazione per arrichire l'InputStream concreto lasciandolo a parte
        . Nell'esercizio camion l'abbiamo fatto
        Tanker che specializza truck -> lo decoriamo e gli mettiamo componenti in più
        il decoratore specializza solo InputStream ed è indipendente dal componente concreto
        FilterInputStream è la classe astratta decoratore e può essere specializzato da BufferedInputStream
        oppure DataInputStream e 
        
        BUONA PRATICA: chiudere alla fine lo stream con finally, con closeable
        
        scriviamo sul file tipi primitivi
        a differenza di write, per la read per uscire dal ciclo usiamo un while infinito che finisce quando
        lancia l'eccezione
        
        Output.Stream (per un problema di scrittura)
        write come read 
        
        
        ObjectInputStream serialaizable che dice al compilatore
        */
        
        /* 22_11 Esercitazione
        
        */
        
        /* 25_11 multithread
        
        */
        
        /* javafx
        
        */
    }
}
