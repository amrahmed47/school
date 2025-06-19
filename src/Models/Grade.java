package Models;

import java.util.ArrayList;
import java.util.Collection;

public class Grade extends Person{
    String code;
    String name;
    Student student = new Student();
    Teacher teacher = new Teacher();
    ArrayList<Student> students;

    public Grade(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<Student>();
    }

    public Grade(){
        this.students = new ArrayList<Student>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }



    public void setStudents(ArrayList<Student> students) {
       this.students = students;
    }
     //public void addStudent(Student student){
       // this.getStudents().add(student);
    //}
    public void removeTeacher(Teacher teacher){
        this.teacher.setName("");
          this.teacher.setAge(0);
          this.teacher.setSalary(0);
    }


    public void removeStudent(Student student){
        this.getStudents().remove(student);
    }
    public String getData() {
        return this.getCode() + " " + teacher.getData();



    }

    public String getDataWithOutTeacher(){
        return this.getCode();

    }

}
