package Classes;

import Controller.Exception_MaxLCurs;
import Controller.Exception_AlreadyExists;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * implementez comparable pentru a putea folosi mai departe metode de comparare a obiectelor
 * => creearea metodelor de sortare din RegistrationSystem
 */
public class Course implements Comparable<Course> {

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

    /**
     * adaug un student anume la lista de studenti inscrisi la cursuri
     * @param student = noul student sau "object"
     */
    public void addStudent(Student student){

        if(studentsEnrolled.contains(student)){
            //System.out.print("Ist schon an den Kurs eingeschrieben");
            //Hausaufgabe 4
            throw new Exception_AlreadyExists("Ist schon an den Kurs eingeschrieben");
        }
        else
        if(studentsEnrolled.size() == maxEnrollement){
            //System.out.print("Kurs hat keine freie Platze mehr");
            //Hausaufgabe 4
            throw new Exception_MaxLCurs("Kurs hat keine freie Platze mehr");
        }
        studentsEnrolled.add(student);
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
        return "Kurs : " + "Name Kurs = " + name + ", Professor = " + teacher + ", maxPlatze =" + maxEnrollement + ", eingeschriebene Studenten = " + studentsEnrolled + ", ECTS = " + credits + "\n" ;
    }

    /**
     * compar 2 instante din lista de cursuri dupa nume
     * @param course1 este un alt "object" de tipul curs/ alt curs
     * @return integer negativ, 0 sau integer pozitiv daca objectul comparat este mai mic, egal, sau mai mare decat celalalt
     */
    @Override
    public int compareTo(Course course1) {
        return this.getName().compareTo(course1.getName());
    }
}


