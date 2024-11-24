package simulazioneaeroportoio;

import java.io.Serializable;

public class CodeCheckEN implements CodeChecker, Serializable {
    @Override
    public boolean check(String codice){
        return codice.matches("^EN\\d{2}[A-Za-z]{2}$");
    }
}
