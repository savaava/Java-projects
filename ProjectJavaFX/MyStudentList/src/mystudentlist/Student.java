package mystudentlist;

public class Student {
    private final String name;
    private final String surname;
    private final String code;

    public Student(String name, String surname, String code) {
        this.name = name;
        this.surname = surname;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCode() {
        return code;
    }
    
    @Override
    public String toString(){
        return "Student -> {name: "+name+" - surname: "+surname+" - code: "+code+"}";
    }
}
