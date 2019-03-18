package orm.DAO;

import java.util.Collection;

public interface EntityOperations<T> {

    int add(T entity); // return id
    T getById(Integer id);
//    void delete(int id);
//    Collection<T> getAll();

}
