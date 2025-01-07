package registroesami;

public class SalvataggioAutomatico implements Runnable {
    private final String filename;
    private final RegistroEsami registro;
    
    public SalvataggioAutomatico(String filename, RegistroEsami registro){
        this.filename = filename;
        this.registro = registro;
    }
    
    @Override
    public void run(){
        while(! Thread.currentThread().isInterrupted()){
            synchronized(registro){
                try{registro.wait();}
                catch(InterruptedException ex){
                    System.out.println("Thread "+Thread.currentThread().getName()+" interrotto");
                    return ;
                }
                
                if(RegistroEsamiUtils.salvaSuFileBinario(filename, registro))
                    System.out.println("Salvataggio riuscito");
                else
                    System.err.println("Errore durante il salvataggio");
            }
        }
    }
}
