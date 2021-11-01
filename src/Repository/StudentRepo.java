package Repository;

import Classes.Student;

public class StudentRepo extends InMemoryRepo<Student> {

    public StudentRepo(){

        super();
    }

    @Override
    public Student update(Student obj) {
        Student sUpdate = this.repoList.stream().filter(student -> student.getStudentId() == obj.getStudentId()).findFirst().orElseThrow();
        sUpdate.setEnrolledCourses(obj.getEnrolledCourses());
        sUpdate.setTotalCredits(obj.getTotalCredits());
        return sUpdate;
    }
}
