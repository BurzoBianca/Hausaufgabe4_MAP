package Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepo <T> implements ICrudRepo<T> {

    protected List<T> repoList;

    public InMemoryRepo(){

        this.repoList = new ArrayList<>();
    }

    //adaug "objectul" in lista
    @Override
    public T create(T obj) {

        this.repoList.add(obj);
        return obj;
    }

    //returnez toate "objectele" din repo
    @Override
    public List<T> getAll() {
        return this.repoList;
    }

    //sterg un "object" din lista
    @Override
    public void delete(T obj) {
        this.repoList.remove(obj);
    }
}
