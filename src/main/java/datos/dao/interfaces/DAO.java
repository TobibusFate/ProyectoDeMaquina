package datos.dao.interfaces;

import java.util.List;

public interface DAO<T> {

    List<T> readAll ();

    T readOne ();

    boolean create (T t);

    boolean update (T t);

    boolean delete (T t);
}
