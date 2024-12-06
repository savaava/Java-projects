package mystudentlist;

public class Student {
    private String name;
    private String surname;
    private String code;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCode(String code) {
        this.code = code;
    }   
    
    @Override
    public String toString(){
        return "Student -> {name: "+name+" - surname: "+surname+" - code: "+code+"}";
    }
}
