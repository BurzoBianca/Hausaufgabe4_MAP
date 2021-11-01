package Repository;

import Classes.Course;

import java.util.Objects;

public class CourseRepo extends InMemoryRepo<Course> {

    public CourseRepo(){

        super();
    }

    @Override
    public Course update(Course obj) {

        Course cUpdate = this.repoList.stream().filter(course -> Objects.equals(course.getName(), obj.getName()) && course.getTeacher() == obj.getTeacher()).findFirst().orElseThrow();
        cUpdate.setCredits(obj.getCredits());
        return cUpdate;
    }

    @Override
    public void delete(Course obj) {
        super.delete(obj);
    }
}
