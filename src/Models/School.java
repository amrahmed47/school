package Models;

import java.util.ArrayList;

public class School {
    String name;
    String address;
    String phoneNumber;
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;
    ArrayList<Grade> grades;

    public School() {
       this.inItObject();
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        this.inItObject();
    }

    private void inItObject(){
        this.teachers = new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();
        this.grades = new ArrayList<Grade>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }



}
