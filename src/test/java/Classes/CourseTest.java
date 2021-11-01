package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    private Student student;
    private Student student2;
    private Student student3;
    private Course course;


    @BeforeEach
    void init() {
        Teacher t1 = new Teacher("Carmen", "Matei");
        course = new Course("MAP", t1, 2, 10);
        t1.addCourse(course);

        Student s1 = new Student("Catalina", "Vasiu", 110);
        Student s2 = new Student("Victor", "Santa", 125);
        Student s3 = new Student("Darius", "Oros", 118);

    }

    @Test
    void addStudent() {

        course.addStudent(student);
        course.addStudent(student2);
        List<Student> expectedStudents = new ArrayList<>(Arrays.asList(student,student2));
        assertEquals(expectedStudents, course.getStudentsEnrolled());

        try{
            course.addStudent(student);
        }
        finally {
            assertEquals(expectedStudents, course.getStudentsEnrolled());
        }

        try{
            course.addStudent(student3);
        }
        finally {
            assertEquals(expectedStudents, course.getStudentsEnrolled());
            assertEquals(2,course.getStudentsEnrolled().size());
        }


    }
}