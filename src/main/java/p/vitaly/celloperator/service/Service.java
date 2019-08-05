package p.vitaly.celloperator.service;

import java.util.List;

/**
 * Service interface.
 * @param <T> - 'dto' class.
 * @param <K> - 'id' ('db entity' primary key class)
 */
public interface Service<T, K> {
    K add(T dto);
    void update(T dto);
    void remove(T dto);
    void removeWith(K id);
    T get(K id);
    List<T> getAll();
}
