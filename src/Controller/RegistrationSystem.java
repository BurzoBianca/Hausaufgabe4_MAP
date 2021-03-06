package Controller;

import Classes.*;
import Repository.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Controller.Exception_Null;



public class RegistrationSystem {

    private CourseRepo courses;
    private TeacherRepo teachers;
    private StudentRepo students;

    public RegistrationSystem(CourseRepo courses, TeacherRepo teachers, StudentRepo students) {

        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    /**
     * inregistrez un student la un curs anume
     * adaug cursul in lista de cursuri a studentului la repo-ul pt studenti
     * adaug studentul la lista de studenti din repo-ul pt cursuri
     * @param course = cursul la care studentul doreste sa se inregistreze
     * @param student = studentul care doreste sa se inregistreze la curs
     * @return true daca toate modificarile au fost efectuate
     */
    public boolean register(Course course, Student student) throws IllegalArgumentException, Exception_Null {

        if (!students.getAll().contains(student)) {

            throw new IllegalArgumentException("Dieser Student existiert nicht");
        } else
            if (!courses.getAll().contains(course)) {

                throw new IllegalArgumentException("Dieser Kurs existiert nicht");
            }
            else {

                //actualizez lista de cursuri a studentului
                student.addCourse(course);
                students.update(student);

                //actualizez lista de studenti a cursului
                course.addStudent(student);
                courses.update(course);

                return true;
            }
    }

    /**
     * returnez o lista de cursuri care mai au locuri libere
     * @return lista de cursuri cu locuri libere
     */
    public List<Course> retrieveCoursesWithFreePlaces() {
        List<Course> CFP = new ArrayList<>();
        for (Course course : courses.getAll()) {
            int fP = course.getMaxEnrollement() - course.getStudentsEnrolled().size();
            if (fP > 0) {
                CFP.add(course);
            }
        }

        return CFP;
    }

    /**
     * returneaza o lista cu toti studentii inscrisi la un curs anume din lista de cursuri
     * @param course cursul de la care dorim sa vedem studentii inscrisi
     * @return lista de studenti
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course)throws IllegalArgumentException {
        if (courses.getAll().contains(course)) {
           return course.getStudentsEnrolled();
        } else
            throw new IllegalArgumentException("Dieser Kurs existiert nicht");
    }

    /**
     * returnez lista cu toate cursurile din repo-ul de cursuri
     * @return lista cu cursuri
     */
    public List<Course> getAllCourses() {
        return courses.getAll();
    }

    /**
     * Sorteaza lista de Studenti din StudentRepo dupa nume
     * @return lista de studenti sortata
     */
    public  List<Student> sortStudents(){
        List<Student> studentsList = students.getAll();
        Collections.sort(studentsList);
        return studentsList;
    }

    /**
     * Sorteaza lista de cursuri din CourseRepo dupa nume
     * @return lista de cursuri sortata
     */
    public List <Course> sortCourses(){
        List<Course> courseList = courses.getAll();
        Collections.sort(courseList);
        return courseList;
    }

}
