package Classes;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;
    private Course course;
    private Course course2;


    @BeforeEach
    void init(){

        Teacher t1 = new Teacher("Carmen", "Matei");
        course = new Course("MAP", t1,2, 10 );
        t1.addCourse(course);

        course2 = new Course("BD", t1, 2, 8 );
        t1.addCourse(course2);

        student = new Student("Catalina", "Vasiu", 110);
        student.addCourse(course);

    }

    @Test
    void addCourse() {

        student.addCourse(course2);
        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(course,course2));
        assertEquals(expectedCourses,student.getEnrolledCourses());
        assertEquals(18,student.getTotalCredits());
    }

    @Test
    void removeCourse() {

        student.addCourse(course2);
        student.removeCourse(course);
        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(course2));
        assertEquals(expectedCourses, student.getEnrolledCourses());
        assertEquals(8, student.getTotalCredits());
    }

    @Test
    void updateCredits() {

        student.addCourse(course2);
        student.updateCredits(course,8);
        assertEquals(16,student.getTotalCredits());

        try {
            student.updateCredits(course2,25);
        }
        finally{
            List<Course> expectedCourses = new ArrayList<>(Arrays.asList(course));
            assertEquals(expectedCourses, student.getEnrolledCourses());
            assertEquals(8,student.getTotalCredits());
        }

    }
}

