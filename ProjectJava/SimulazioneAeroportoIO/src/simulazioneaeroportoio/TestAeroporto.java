package simulazioneaeroportoio;


public class TestAeroporto {
    public static void main(String[] args) {
        Aeromobile[] v = inizializzaAeromobili();
        
        System.out.println("\n\n======= Test n. 1 - Aeroporto senza CodeChecker =======,");
        eseguiTest(null, v);

        System.out.println("\n\n\n============== Test n. 2 - Aeroporto con CodeChecker IT ==============");
        eseguiTest(new CodeCheckIT(), v);

        System.out.println("\n\n\n============== Test n. 3 - Aeroporto con CodeChecker EN ==============");
        eseguiTest(new CodeCheckEN(), v);
    }
    
    private static Aeromobile[] inizializzaAeromobili(){
        Aeromobile[] v = new Aeromobile[10];
        v[0] = new AereoAMotore("KL234", 4);
        v[1] = new AereoAMotore("ITmJ954", 2);
        v[2] = new AereoAMotore("EN66IO", 1);
        v[3] = new AereoAMotore("ITPPM22", 3);
        v[4] = new AereoAMotore("itIF671", 4);
        v[5] = new Aliante("IQ721", 0.34);
        v[6] = new Aliante("ITPO251", 0.26);
        v[7] = new Aliante("EN65IK", 0.44);
        v[8] = new Aliante("ITOL966", 0.16);
        v[9] = new Aliante("EN19UIK", 0.16);
        return v;
    }
    
    private static void eseguiTest(CodeChecker c, Aeromobile v[]){
        Aeroporto a;
        int inserimenti;
        String codiceRicerca, codiceCancellazione;
        Aeromobile cercato, eliminato;
        
//        System.out.println("Test inserimenti");
        a = new Aeroporto(c);
        inserimenti = 0;
        for(int i=0; i<10; i++){
            if(a.inserisci(v[i]))
                inserimenti++;            
        }
//        System.out.println("Sono stati effettuati n. " + inserimenti + " inserimenti");
//        System.out.println("Elementi inseriti:\n" + a);
//        
//        System.out.println("Test ricerca");        
//        codiceRicerca = "KL234";
//        System.out.println("Ricerca in base al codice: " + codiceRicerca);
//        cercato = a.cerca(codiceRicerca);
//        if(cercato!=null)
//            System.out.println("Aeromobile trovato: " + cercato);
//        else
//            System.out.println("Nessun aeromobile corrisponde al criterio di ricerca");
//        
//        System.out.println("\nTest cancellazione");
//        codiceCancellazione = "EN65IK";
//        System.out.println("Cancellazione codice: " + codiceCancellazione);
//        eliminato = a.rimuovi(codiceCancellazione);
//        if ( eliminato != null )
//            System.out.println("Aeromobile eliminato: " + eliminato);
//        else
//            System.out.println("Nessun aeromobile corrisponde al criterio di ricerca");       
//        System.out.println("Numero elementi residui: " + a.elementi());
        
        
        /* Simulazione I/O streams */
        String strFile1 = "Aeroporto.bin";
        System.out.println("Aeroporto da scrivere in "+strFile1+"\n"+a);
        a.salvaDOS(strFile1);
        System.out.println("Aeroporto letto dal "+strFile1+"\n"+Aeroporto.leggiDIS(strFile1));
        
        System.out.println("\n-----------------SERIALIZZAZIONE-----------------");
        
        String strFile2 = "AeroportoSerializzato.bin";
        System.out.println("Aeroporto da scrivere con serializzazione in "+strFile2+"\n"+a);
        a.salvaOBJ(strFile2);
        System.out.println("Aeroporto letto con deserializzazione"+strFile2+"\n"+Aeroporto.leggiOBJ(strFile2));
    }
}
