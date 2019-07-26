package p.vitaly.celloperator.dao;

import java.util.List;

/**
 * Data Access Object interface.
 * @param <T> - 'db entity' class.
 * @param <K> - 'Primary Key' class
 */
public interface Dao<T, K> {
    void add(T entity);
    void update(T entity);
    void remove(T entity);
    T get(K id);
    List<T> getAll();
}