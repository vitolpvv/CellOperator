package p.vitaly.celloperator.dao;

import p.vitaly.celloperator.entity.Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class DaoImpl<T extends Entity> implements Dao<T, Integer> {

    @PersistenceContext
    EntityManager em;

    private final Class<T> entityClass;

    protected DaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

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
        return em.find(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }
}
