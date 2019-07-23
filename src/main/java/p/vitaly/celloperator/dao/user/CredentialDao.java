package p.vitaly.celloperator.dao.user;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.user.CredentialEntity;

@Repository
public class CredentialDao extends DaoImpl<CredentialEntity> {
    @Override
    protected Class<CredentialEntity> getEntityType() {
        return CredentialEntity.class;
    }
}
