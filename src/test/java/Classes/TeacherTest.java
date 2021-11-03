package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;
    private Course course;
    private Course course2;

    @BeforeEach
    void init() {
        teacher = new Teacher("Carmen", "Matei");
        course = new Course("MAP", teacher, 2, 10);
        course2 = new Course("BD", teacher, 2, 8);
        teacher.addCourse(course);
    }


    @Test
    void addCourse() {

        teacher.addCourse(course2);
        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(course,course2));
        assertEquals(expectedCourses,teacher.getCourses());
        try{
            teacher.addCourse(course);
        }
        finally {
            assertEquals(expectedCourses, teacher.getCourses());
        }
    }

    @Test
    void removeCourse() {

        teacher.addCourse(course2);
        teacher.removeCourse(course);
        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(course2));
        assertEquals(expectedCourses,teacher.getCourses());

        try{
            teacher.removeCourse(course);
        }
        finally {
            assertEquals(expectedCourses, teacher.getCourses());
        }
    }
}