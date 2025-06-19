package Services;

import Models.Grade;
import Models.School;
import Models.Student;
import Models.Teacher;

import java.util.Locale;

public class SchoolServices {
    School school;
    Grade grade;
    public SchoolServices(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }
    public void addStudent(Student student){
        this.school.getStudents().add(student);

    }
    public void removeStudentFromGrade(Student student1){
        for(Grade grade: this.school.getGrades()){
            for(Student student : grade.getStudents()){
                if(student == student1){
                    grade.getStudents().remove(student);
                }
            }
        }
    }

    public void addTeacher(Teacher teacher){
        this.school.getTeachers().add(teacher);
    }
    public void addGrade(Grade grade){
        this.school.getGrades().add(grade);
    }

    public void removeStudent(Student student){
        this.school.getStudents().remove(student);
    }
    public void removeTeacher(Teacher teacher){
        this.school.getTeachers().remove(teacher);
    }
    public void removeGrade(Grade grade){
        this.school.getGrades().remove(grade);
    }
    public void removeTeacherFromGrade(Teacher teacher){
        for(Grade grade : this.school.getGrades()){
            if(grade.getTeacher() == teacher){
                grade.removeTeacher(teacher);
            }
        }
    }


    public Student getStudentByName(String name){
        Student a = null;
        for(Student student:this.school.getStudents()){
            if(student.getName().toUpperCase().equals(name.toUpperCase())){
               a = student;
               break;
            }
        }
        return a;
    }

    public Teacher getTeacherByName(String name){
        Teacher a = null;
        for(Teacher teacher:this.school.getTeachers()){
            if(teacher.getName().toUpperCase().equals(name.toUpperCase())){
                a = teacher;
                break;
            }
        }
        return a;
    }

    public Grade getGradeByCode(String code){
        Grade a = null;
        for(Grade grade:this.school.getGrades()){
            if(grade.getCode().toUpperCase().equals(code.toUpperCase())){
                a = grade;
                break;
            }
        }
        return a;
    }

}
