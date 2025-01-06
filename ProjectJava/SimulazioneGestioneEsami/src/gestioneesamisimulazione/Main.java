package gestioneesamisimulazione;

public class Main {
    public static void main(String[] args) {
        String filenameCSV = "esami.txt";
        String filenameSer = "esami.ser";
        
        LibrettoEsami l = new LibrettoEsami();
        
        l.caricamentoDaFileTxt(filenameCSV);
        System.out.println(l+"\n");
        
        String m = "0612700212";
        System.out.println("Esami superati da studente "+m+":\n"+l.filtroPerMatricola(m)+"\n");
        String insegnamento = "Basi di Dati";
        System.out.println("Studenti che hanno superato l'esame "+insegnamento+":\n"
                +l.filtroPerNomeInsegnamento(insegnamento)+"\n");
        
        l.scritturaSer(filenameSer);
        
        System.out.println(LibrettoEsami.letturaSer(filenameSer)+"\n");
        
        
        System.out.println("Ordinamento libretto per Nome Insegnamento:\n"
                +l.getLibrettoOrdinato(new ComparatorInsegnamento())+"\n");        
        System.out.println("Ordinamento libretto per Matricola:\n"
                +l.getLibrettoOrdinato(new ComparatorMatricola())+"\n");
    }
}
