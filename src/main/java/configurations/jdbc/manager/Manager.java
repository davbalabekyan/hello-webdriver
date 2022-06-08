package configurations.jdbc.manager;

import java.util.List;

public interface Manager<T, E> {

    List<T> getAll();

    T getById(E id);

    void create(T object);

    void update(T object);

    void delete(E id);
}
