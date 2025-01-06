package aeroportosimulazione;

public class CodeCheckIT implements CodeChecker, java.io.Serializable{
    @Override
    public boolean check(String codice){
        return codice.matches("^IT[A-Za-z]{2}\\d{3}$");
    }
}
