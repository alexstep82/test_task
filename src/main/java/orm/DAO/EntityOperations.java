package orm.DAO;

import java.sql.SQLException;
import java.util.Collection;

public interface EntityOperations<I, T> {

    I add(T entity) ; // return id
    T getById(I id) ;
//    void delete(int id);
//    Collection<T> getAll();

}
