package oop2017.contest1.gruppo77;

public class CodeCheckIT implements CodeChecker{
    @Override
    public boolean check(String codice){
        return codice.matches("^IT[a-zA-Z]{2}\\d{3}$");
    }
}
