package simulazioneaeroportoio;

import java.io.Serializable;

public class CodeCheckIT implements CodeChecker, Serializable {
    @Override
    public boolean check(String codice){
        return codice.matches("^IT[A-Za-z]{2}\\d{3}$");
    }
}
