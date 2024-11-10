package contest1.gruppo77.classes;

public class Student extends Person {
    private final String matricola;
    
    public Student(String name, String surname, String matricola, int year, int month, int dayOfMonth) {
        super(name, surname, year, month, dayOfMonth);
        this.matricola = matricola;
    }
    
    public String getMatricola() {
        return this.matricola;
    }
    
    @Override
    public String toString(){
        return super.toString()+"Matricola = "+this.matricola+"\n";
    }
}
