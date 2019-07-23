package p.vitaly.celloperator.dao;

import p.vitaly.celloperator.entity.Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class DaoImpl<T extends Entity> implements Dao<T, Integer> {

    private final Class<T> type = getEntityType();

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    @Override
    public void remove(T entity) {
        em.getTransaction().begin();
        if (!em.contains(entity)) {
            em.merge(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public T get(Integer id) {
        return em.find(type, id);
    }

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + type, type).getResultList();
    }

    protected abstract Class<T> getEntityType();
}
