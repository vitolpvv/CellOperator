package p.vitaly.celloperator.dao.contract;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.contract.BlockedContractEntity;

@Repository
public class BlockedContactDao extends DaoImpl<BlockedContractEntity> {
    @Override
    protected Class<BlockedContractEntity> getEntityType() {
        return BlockedContractEntity.class;
    }
}
