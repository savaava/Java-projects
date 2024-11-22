package simulazioneaeroportoio;

public class CodeCheckEN implements CodeChecker {
    @Override
    public boolean check(String codice){
        return codice.matches("^EN\\d{2}[A-Za-z]{2}$");
    }
}
