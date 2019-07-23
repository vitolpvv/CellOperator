package p.vitaly.celloperator.dao.contract;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.contract.ContractEntity;

@Repository
public class ContractDao extends DaoImpl<ContractEntity> {
    @Override
    protected Class<ContractEntity> getEntityType() {
        return ContractEntity.class;
    }
}
