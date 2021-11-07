package Repository;

import Controller.Exception_Null;
import java.util.List;

public interface ICrudRepo <T> {

    T create(T obj);
    List<T> getAll();
    T update(T obj) throws Exception_Null;
    void delete(T obj) throws Exception_Null;
}

