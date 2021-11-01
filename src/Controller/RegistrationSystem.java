package Controller;

import Classes.*;
import Repository.*;

import java.util.List;
import java.util.ArrayList;

public class RegistrationSystem {

    private CourseRepo courses;
    private TeacherRepo teachers;
    private StudentRepo students;

    public RegistrationSystem(CourseRepo courses, TeacherRepo teachers, StudentRepo students) {

        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    public boolean register(Course course, Student student) {

        if (!students.getAll().contains(student)) {

            System.out.print("Dieser Student existiert nicht");
        } else {

            if (!courses.getAll().contains(course)) {

                System.out.print("Dieser Kurs existiert nicht");
            } else {

                student.addCourse(course);
                students.update(student);

                return true;
            }
        }

        return false;
    }

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

    public List<Student> retrieveStudentsEnrolledForACourse(Course course) {
        if (courses.getAll().contains(course)) {
           return course.getStudentsEnrolled();
        } else
            System.out.print("Dieser Kurs existiert nicht");
        return null;
    }

    public List<Course> getAllCourses() {
        return courses.getAll();
    }

}
