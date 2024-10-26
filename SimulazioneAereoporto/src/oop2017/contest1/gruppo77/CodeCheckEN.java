package oop2017.contest1.gruppo77;

public class CodeCheckEN implements CodeChecker{
    @Override
    public boolean check(String codice){
        return codice.matches("^EN\\d{2}[a-zA-Z]{2}$");
    }
}
