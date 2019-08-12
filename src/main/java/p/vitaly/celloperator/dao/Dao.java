package p.vitaly.celloperator.dao;

import java.util.List;

/**
 * Data Access Object interface.
 * @param <T> - 'db entity' class.
 * @param <K> - 'Primary Key' class
 */
public interface Dao<T, K> {
    K add(T entity);
    void update(T entity);
    K save(T entity);
    void remove(T entity);
    void removeWith(K id);
    T get(K id);
    List<T> getAll();
}