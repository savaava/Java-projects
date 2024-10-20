package contest1.gruppo77.classes;

import contest1.gruppo77.enums.TeacherType;

public class Teacher extends Person {
    private final TeacherType type;
    
    public Teacher(String name, String surname, TeacherType type, int year, int month, int dayOfMonth) {
        super(name, surname, year, month, dayOfMonth);
        this.type = type;
    }
    
    public TeacherType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nType = "+this.type;
    }
}
