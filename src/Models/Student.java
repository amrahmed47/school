package Models;

public class Student extends Person {
    String parentPhNumber;
    String code;
    public Student(String name, int age, String parentPhNumber, String code) {
        super(name, age);
        this.parentPhNumber = parentPhNumber;
        this.code = code;
    }

    public Student() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentPhNumber() {
        return parentPhNumber;
    }

    public void setParentPhNumber(String parentPhNumber) {
        this.parentPhNumber = parentPhNumber;
    }

    @Override
    public String getData() {
        return this.getName() + " " + this.getAge() + " " + this.getParentPhNumber();
    }
}
