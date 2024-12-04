package gestioneesamiio;

public class TestGestioneEsamiIO {
    public static void main(String[] args) {
        LibrettoEsami l = LibrettoEsami.readFromTextFile("esami.txt");
        System.out.println("****** libretto dal file letto ******\n"+l);
        
        l.salvataggioOBJ("esami.bin");
        //System.out.println(LibrettoEsami.caricamentoOBJ("esami.bin"));
        
        System.out.println("\n\n****** esami ordinati per nome dell'insegnamento ******\n"
                +l.getLibrettoOrdinato(new ComparatoreNomeEsame()));
    }
}
