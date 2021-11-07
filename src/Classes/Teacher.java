package Classes;

import java.util.List;
import java.util.ArrayList;

public class Teacher extends Person {

    private List<Course> courses;

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        courses = new ArrayList<>();
    }

    /**
     * adaug un curs anume la lista de cursuri ale profesorului
     * @param course = noul curs sau "object"
     */
    public void addCourse(Course course){

        if(courses.contains(course)){

            System.out.print("Kurs existiert schon in der Liste des Proffesoren");
        }
        else{
            courses.add(course);
        }
    }

    /**
     * sterg un curs anume din lista de cursuri ale profesorului
     * @param course = cursul sau "object-ul"
     */
    public void removeCourse(Course course) throws IllegalArgumentException{

        if(!courses.contains(course)){

            //System.out.print("Kurs existiert nicht in der Liste des Proffesoren");
            //Hausaufgabe 4
            throw new IllegalArgumentException("Kurs existiert nicht in der Liste des Proffesoren");
        }
        else{

            courses.remove(course);
        }
    }

    public List<Course> getCourses() {
            return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
