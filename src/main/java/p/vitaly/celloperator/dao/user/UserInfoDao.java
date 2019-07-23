package p.vitaly.celloperator.dao.user;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.user.UserInfoEntity;

@Repository
public class UserInfoDao extends DaoImpl<UserInfoEntity> {
    @Override
    protected Class<UserInfoEntity> getEntityType() {
        return UserInfoEntity.class;
    }
}
