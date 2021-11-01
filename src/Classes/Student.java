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

    public Student(String firstName, String lastName, long studentId, int totalCredits) {

        super(firstName, lastName);
        this.studentId = studentId;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

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

    public void removeCourse(Course course){

        if(!enrolledCourses.contains(course)){

            System.out.print("Kurs existiert nicht in der Liste des Studenten");
        }
        else {

            totalCredits -= course.getCredits();
            enrolledCourses.remove(course);
        }
    }

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
