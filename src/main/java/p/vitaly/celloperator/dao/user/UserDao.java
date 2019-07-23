package p.vitaly.celloperator.dao.user;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.user.UserEntity;

@Repository
public class UserDao extends DaoImpl<UserEntity> {
    @Override
    protected Class<UserEntity> getEntityType() {
        return UserEntity.class;
    }
}
