package Repository;

import Classes.Teacher;

import java.util.Objects;

public class TeacherRepo extends InMemoryRepo<Teacher> {

    public TeacherRepo(){
        super();
    }

    //editez dupa nume si prenume, lista de cursuri a unui profesor din repo
    @Override
    public Teacher update(Teacher obj) {

        Teacher tUpdate = this.repoList.stream().filter(teacher -> Objects.equals(teacher.getFirstName(), obj.getFirstName()) && Objects.equals(teacher.getLastName(), obj.getLastName())).findFirst().orElseThrow();
        tUpdate.setCourses(obj.getCourses());
        return tUpdate;
    }
}
