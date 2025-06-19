package Main;

import Models.*;
import Services.SchoolServices;
import tools.Actions;

import java.util.Scanner;

public class HMI {
    private static Grade grade;
    private static Scanner scanner = new Scanner(System.in);
    private static  SchoolServices schoolServices;
    public static void start(){


        School school = HMI.creatSchool();
        HMI.schoolServices = new SchoolServices(school);
        HMI.grade = new Grade();
        System.out.println("Welcome to " + school.getName() + " in (" + school.getAddress() + ") school Phone : " + school.getPhoneNumber());
        String action;
        do{
            System.out.println("what do you want to do");
            action = HMI.scanner.next();

            switch (action){
                case "removeGrade":
                    removeGrade();
                    break;
                case "findGradeByCode":
                    HMI.findGradeByCode();
                    break;
                case "printAllGrades":
                    HMI.printAllGrades();
                    break;
                case "printAllStudent":
                    HMI.printAllStudent();
                    break;
                case "createGrade":
                    createGrade();
                    break;
                case "printAllTeacher":
                    HMI.printAllTeacher();
                    break;
                case "findStudentByName":
                    HMI.printPersonByName(Actions.STUDENT);
                    break;
                case "findTeacherByName":
                    HMI.printPersonByName(Actions.TEACHER);
                    break;
                case "removeTeacherByName":
                    HMI.removePersonByName(Actions.TEACHER);
                    break;
                case "removeStudentByName":
                    HMI.removePersonByName(Actions.STUDENT);
                    break;
            }

        }while (!action.equals("exit"));
    }

    private static School creatSchool(){
        School school = new School();
        school.setName("Programming School");
        school.setAddress("Egypt");
        school.setPhoneNumber("+201285697417");
        return school;
    }
    private static  void createGrade(){
        String as;
       Grade grade = new Grade();
        System.out.println("Enter a grade");
        grade.setCode(HMI.scanner.next());
        Teacher teacher = HMI.addTeacher();
        grade.setTeacher(teacher);
        System.out.println("Do you want to add a student? (yes, no)");
        as = HMI.scanner.next();

       while(!as.equals("no")){
           grade.getStudents().add(HMI.addStudent());
           System.out.println("Do you want to add a student? ( yes,  no)");
           as = HMI.scanner.next();
       }


        HMI.schoolServices.addGrade(grade);
    }

    private static Student addStudent(){
        Student student = new Student();
        HMI.setDataPerson(student);
        HMI.schoolServices.addStudent(student);
        return student;

    }

    private static Teacher addTeacher(){
        Teacher teacher = new Teacher();
        HMI.setDataPerson(teacher);
        HMI.schoolServices.addTeacher(teacher);
        return teacher;
    }

    private static void printAllGrades(){
        for(Grade grade : HMI.schoolServices.getSchool().getGrades()){
            if(grade.getTeacher().getName().equals("")){
                System.out.println(grade.getDataWithOutTeacher());
            }else {System.out.println(grade.getData());}
            for(Student student : grade.getStudents()){
                System.out.println(student.getData());
            }
        }
    }

    private static void printAllStudent(){
        for(Student student: HMI.schoolServices.getSchool().getStudents()){
            System.out.println(student.getData());
        }
    }

    private static void printAllTeacher(){
        for(Teacher teacher: HMI.schoolServices.getSchool().getTeachers()){
            System.out.println(teacher.getData());
        }
    }

    private static void setDataPerson(Person p){
       // Scanner scanner = new Scanner(System.in);
        System.out.println("enter person's name");
        p.setName(scanner.next());
        System.out.println("enter person's age");
        p.setAge(scanner.nextInt());
        if(p instanceof Teacher){
            System.out.println("enter teacher's salary");
            ((Teacher) p).setSalary(scanner.nextInt());
        }else {
            System.out.println("enter parent phone number");
            ((Student)p).setParentPhNumber(scanner.next());
        }
    }

    private static Grade getDataGrade(){

        String code;
        System.out.println("Enter the code");
        code = scanner.next();
        HMI.grade = HMI.schoolServices.getGradeByCode(code);
        return grade;
    }

    private static void findGradeByCode(){

        HMI.grade = HMI.getDataGrade();
        if(HMI.grade == null){
            System.out.println("Not available");

        }else {
            System.out.println(grade.getData());

            for (Student student : HMI.grade.getStudents()) {
                System.out.println(student.getData());
            }
        }
    }
private static void removeGrade(){
        Grade grade;
        grade = HMI.getDataGrade();
        HMI.schoolServices.removeGrade(grade);

}
    private static void printPersonByName(Actions action){
        Person p = HMI.findPersonByName(action);
        if(p == null){
            System.out.println("Not Found !!!");
        }else {
            System.out.println(p.getData());
        }
    }

    private static Person findPersonByName(Actions action){
        Person p;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Person's name");
        String name = reader.next();
        if(action == Actions.TEACHER){
            p = HMI.schoolServices.getTeacherByName(name);
        }else {
            p = HMI.schoolServices.getStudentByName(name);
        }

        return p;
    }

    private static void removePersonByName(Actions action){
        Person p = HMI.findPersonByName(action);
        if(p instanceof Teacher){
            HMI.schoolServices.removeTeacher((Teacher) p);
            HMI.schoolServices.removeTeacherFromGrade((Teacher) p);
        }else {
            HMI.schoolServices.removeStudentFromGrade((Student) p);
            HMI.schoolServices.removeStudent((Student) p);
        }
    }
}
