package simulazioneaeroportoio;

import java.io.Serializable;

public interface CodeChecker extends Serializable{
    boolean check(String codice);
}
