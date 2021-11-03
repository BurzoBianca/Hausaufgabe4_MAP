package Controller;

import Classes.*;
import Repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {

    RegistrationSystem rs;
    Teacher t1; Teacher t2;
    Course c1; Course c2;Course c3;
    Student s1; Student s2; Student s3;
    StudentRepo studentRepo;
    TeacherRepo teacherRepo;
    CourseRepo courseRepo;

    @BeforeEach
    void init(){

        teacherRepo = new TeacherRepo();
        t1 = new Teacher("Carmen", "Matei");
        t2 = new Teacher("Cornelia", "Ignat");
        teacherRepo.create(t1);
        teacherRepo.create(t2);

        courseRepo = new CourseRepo();
        c1 = new Course("MAP", t1,2, 10 );
        c2 = new Course("BD", t1, 2, 10);
        c3  = new Course("LP", t2, 2, 11);

        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c3);

        courseRepo.create(c1);
        courseRepo.create(c2);
        courseRepo.create(c3);


        studentRepo = new StudentRepo();
        s1 = new Student("Catalina", "Vasiu", 110);
        s2 = new Student("Victor", "Santa", 125);
        s3 = new Student("Darius", "Oros", 118);
        studentRepo.create(s1);
        studentRepo.create(s2);
        studentRepo.create(s3);

        rs = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);

        rs.register(c1,s1);
        rs.register(c1,s2);

        rs.register(c2,s1);
        rs.register(c2,s3);

        rs.register(c3,s3);
        rs.register(c3,s1);
    }

    @Test
    void register() {

        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(c1, c2));
        assertEquals(expectedCourses, s1.getEnrolledCourses());

        List<Student> expectedStudents = new ArrayList<>(Arrays.asList(s1, s3));
        assertEquals(expectedStudents, c2.getStudentsEnrolled());

        Student s4 = new Student("Maria", "Marcu", 203);
        List<Course> expectedCourses2 = new ArrayList<>(List.of());
        List<Student> expectedStudents2 = new ArrayList<>(List.of(s3));
        try {
            rs.register(c3, s4);
        } finally {
            assertEquals(expectedCourses2, s4.getEnrolledCourses());
            assertEquals(expectedStudents2, c3.getStudentsEnrolled());
        }

        Course c4 = new Course("DSA", t1, 2, 5);
        List<Student> expectedStudents3 = new ArrayList<>(List.of());
        try {
            rs.register(c4, s1);
        } finally {
            assertEquals(expectedCourses, s1.getEnrolledCourses());
            assertEquals(expectedStudents3, c4.getStudentsEnrolled());
        }

    }

    @Test
    void retrieveCoursesWithFreePlaces() {

        List<Course> freePlacesCourses = rs.retrieveCoursesWithFreePlaces();
        List<Course> expectedCourses = new ArrayList<>(List.of(c3));
        assertEquals(expectedCourses,freePlacesCourses);
    }

    @Test
    void retrieveStudentsEnrolledForACourse(){

        List<Student> enrolledStudents = rs.retrieveStudentsEnrolledForACourse(c2);
        List<Student> expectedStudents = new ArrayList<>(Arrays.asList(s1, s3));
        assertEquals(expectedStudents,enrolledStudents);
    }

    @Test
    void getAllCourses(){

        List<Course> allCourses = rs.getAllCourses();
        List<Course> expectedCourses = new ArrayList<>(Arrays.asList(c1, c2, c3));
        assertEquals(expectedCourses,allCourses);
    }
}

