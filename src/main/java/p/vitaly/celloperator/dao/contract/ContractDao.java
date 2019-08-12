package p.vitaly.celloperator.dao.contract;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.contract.ContractEntity;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ContractDao extends DaoImpl<ContractEntity> {

    public ContractDao() {
        super(ContractEntity.class);
    }

    public List<ContractEntity> getContractsByUser(Integer userId) {
        TypedQuery<ContractEntity> tq = em.createQuery("from ContractEntity as c where c.user.id  = :userId", ContractEntity.class);
        tq.setParameter("userId", userId);
        return tq.getResultList();
    }
}
