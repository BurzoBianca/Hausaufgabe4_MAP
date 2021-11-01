package com.company;

import Controller.RegistrationSystem;
import Classes.*;
import Repository.*;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TeacherRepo teacherRepo = new TeacherRepo();
        Teacher t1 = new Teacher("Carmen", "Matei");
        Teacher t2 = new Teacher("Cornelia", "Ignat");
        teacherRepo.create(t1);
        teacherRepo.create(t2);

        CourseRepo courseRepo = new CourseRepo();
        Course c1 = new Course("MAP", t1,2, 10 );
        Course c2 = new Course("BD", t1, 2, 10);
        Course c3  = new Course("LP", t2, 2, 11);

        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c3);

        courseRepo.create(c1);
        courseRepo.create(c2);
        courseRepo.create(c3);


        StudentRepo studentRepo = new StudentRepo();
        Student s1 = new Student("Catalina", "Vasiu", 110);
        Student s2 = new Student("Victor", "Santa", 125);
        Student s3 = new Student("Darius", "Oros", 118);
        studentRepo.create(s1);
        studentRepo.create(s2);
        studentRepo.create(s3);

        RegistrationSystem rs = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);
        rs.register(c1,s1);
        rs.register(c1,s2);
        rs.register(c2,s1);
        rs.register(c2,s3);
        rs.register(c3,s3);
        rs.register(c3,s1);

        System.out.println(s1.getTotalCredits());
        System.out.print("\n");
        System.out.println(rs.retrieveCoursesWithFreePlaces());
        System.out.print("\n");
        rs.retrieveStudentsEnrolledForACourse(c2);
        System.out.print("\n");
        System.out.println(rs.getAllCourses());


    }
}

