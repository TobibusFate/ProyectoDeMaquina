package datos.dao;

import java.util.List;

public interface IDAO<T> {

    List<T> read (T t);

    boolean create (T t);

    boolean update (T t);

    boolean delete (T t);
}
