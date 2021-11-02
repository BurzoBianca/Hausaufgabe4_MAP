package Classes;

import Classes.Course;
import Classes.Person;


import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person {

    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, long studentId) {

        super(firstName, lastName);
        this.studentId = studentId;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * adaug studentul la lista de studenti din repo-ul pt cursuri
     * adaug nr de credite al cursului la totalul de credite
     * @param course = noul curs sau "object"
     */
    public void addCourse(Course course) {

        if (enrolledCourses.contains(course)) {

            System.out.print("Kurs ist schon in der Liste des Studenten");
        }
        else{

            if (totalCredits + course.getCredits() <= 30) {

                enrolledCourses.add(course);
                totalCredits += course.getCredits();
            }
            else {

                System.out.print("ECTS Limit wurde erreicht !");
            }
        }
    }

    /**
     * sterg un curs anume din lista de cursuri a studentului
     * scad din totalul de credite nr de credite ale cursului sters
     * @param course = noul curs sau "object"
     */
    public void removeCourse(Course course){

        if(!enrolledCourses.contains(course)){

            System.out.print("Kurs existiert nicht in der Liste des Studenten");
        }
        else {

            totalCredits -= course.getCredits();
            enrolledCourses.remove(course);
        }
    }

    /**
     * schimb "suma" creditelor in functie de nr creditelor pe care trebuie sa il modific pt un curs anume
     * @param course = noul curs sau "object"
     * @param credits = noua valoare pt credite
     */
    public void updateCredits(Course course, int credits){

        if(!enrolledCourses.contains(course)){

            System.out.print("Kurs existiert nicht in der Liste des Studenten");
        }
        else{

            for(Course i : enrolledCourses){

                if(Objects.equals(i.getName(), course.getName())){

                    int val = totalCredits - i.getCredits() + credits;

                    if(val <= 30){

                        totalCredits = val;
                        break;
                    }
                    else{

                        enrolledCourses.remove(i);
                        totalCredits -= i.getCredits();
                        System.out.print("ECTS Limit wurde fur Student : " + this.studentId + "erreicht !");
                        System.out.print("\n");
                        System.out.print("Kurs wurde geloscht.");
                    }
                }
            }
        }
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student : " + "Vorname = " + getFirstName() + ", Name = " + getLastName() + ", StudentId = " + studentId + ", Total ECTS = " + totalCredits ;
    }

}
