package Repository;

import Controller.Exception_Null;

import Classes.Course;

import java.util.Objects;

public class CourseRepo extends InMemoryRepo<Course> {

    public CourseRepo(){

        super();
    }

    /**
     * editez lista de studenti a unui curs in repo
     * @param obj = cursul cu o noua lista de studenti
     * @return cursul actualizat
     */
    @Override
    public Course update(Course obj) throws Exception_Null{

        if(obj == null)
            throw new Exception_Null("Null object!");

        Course cUpdate = this.repoList.stream().filter(course -> Objects.equals(course.getName(), obj.getName()) && course.getTeacher() == obj.getTeacher()).findFirst().orElseThrow();
        cUpdate.setCredits(obj.getCredits());
        return cUpdate;
    }

    /**
     * sterg cursul din repo
     * @param obj = cursul ce trebuie sters
     */
    @Override
    public void delete(Course obj) throws Exception_Null{

        if(obj == null)
            throw new Exception_Null("Null id!");

        super.delete(obj);
    }
}
