package p.vitaly.celloperator.dao;

import p.vitaly.celloperator.entity.Entity;

import java.util.List;

public interface Dao<T extends Entity, K> {
    void add(T entity);
    void update(T entity);
    void remove(T entity);
    T get(K id);
    List<T> getAll();
}
