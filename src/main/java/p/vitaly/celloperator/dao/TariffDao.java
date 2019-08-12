package p.vitaly.celloperator.dao;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.entity.TariffEntity;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TariffDao extends DaoImpl<TariffEntity> {

    public TariffDao() {
        super(TariffEntity.class);
    }

    public List<TariffEntity> getAllActive() {
        TypedQuery<TariffEntity> tq = em.createQuery("from TariffEntity t where t.archived = :archived", TariffEntity.class);
        tq.setParameter("archived", false);
        return tq.getResultList();
    }
}
