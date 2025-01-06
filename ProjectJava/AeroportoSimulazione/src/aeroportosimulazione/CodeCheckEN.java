package aeroportosimulazione;

public class CodeCheckEN implements CodeChecker, java.io.Serializable {
    @Override
    public boolean check(String codice){
        return codice.matches("^EN\\d{2}[A-Za-z]{2}$");
    }
}
