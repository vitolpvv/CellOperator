package p.vitaly.celloperator.dao.user;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.user.RoleEntity;

@Repository
public class RoleDao extends DaoImpl<RoleEntity> {
    @Override
    protected Class<RoleEntity> getEntityType() {
        return RoleEntity.class;
    }
}
