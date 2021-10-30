import java.util.List;

public class Course {

    public String name;
    public Person teacher;
    public int maxEnrollement;
    public List<Student> studentEnrolled;
    public int credits;

    public Course(String name, Person teacher, int maxEnrollement, List<Student> studentEnrolled, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollement = maxEnrollement;
        this.studentEnrolled = studentEnrolled;
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

    public List<Student> getStudentEnrolled() {
        return studentEnrolled;
    }

    public void setStudentEnrolled(List<Student> studentEnrolled) {
        this.studentEnrolled = studentEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
