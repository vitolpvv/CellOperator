package p.vitaly.celloperator.dao;

import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Basic abstract Data Access Object implementation with Integer Primary Key.
 * @param <T> - 'db entity' class.
 */
public abstract class DaoImpl<T extends GeneratedIdEntity> implements Dao<T, Integer> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> entityClass;

    protected DaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Integer add(T entity) {
        em.persist(entity);
        return entity.getId();
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public Integer save(T entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity.getId();
    }

    @Override
    public void remove(T entity) {
        if (!em.contains(entity)) {
            em.merge(entity);
        }
        em.remove(entity);
    }

    @Override
    public void removeWith(Integer id) {
        em.createQuery("delete from " + entityClass.getName() + " e where e.id=" + id).executeUpdate();
    }

    @Override
    public T get(Integer id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }
}
