package Classes;

import java.util.ArrayList;
import java.util.List;

public class Course {

    public String name;
    public Person teacher;
    public int maxEnrollement;
    public List<Student> studentsEnrolled;
    public int credits;

    public Course(String name, Person teacher, int maxEnrollement, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollement = maxEnrollement;
        this.studentsEnrolled = new ArrayList<Student>();
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollement() {
        return maxEnrollement;
    }

    public void setMaxEnrollement(int maxEnrollement) {
        this.maxEnrollement = maxEnrollement;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Kurs : " + "Name Kurs = " + name + ", Professor = " + teacher + ", maxPlatze =" + maxEnrollement + ", eingeschriebene Studenten = " + studentsEnrolled + ", ECTS = " + credits ;
    }
}


