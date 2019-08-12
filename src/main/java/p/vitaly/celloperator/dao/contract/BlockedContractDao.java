package p.vitaly.celloperator.dao.contract;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.contract.BlockedContractEntity;

@Repository
public class BlockedContractDao extends DaoImpl<BlockedContractEntity> {

    public BlockedContractDao() {
        super(BlockedContractEntity.class);
    }
}
