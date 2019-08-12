package p.vitaly.celloperator.dao.user;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.user.UserEntity;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao extends DaoImpl<UserEntity> {

    public UserDao() {
        super(UserEntity.class);
    }

    public List<UserEntity> getAllClients(){
        TypedQuery<UserEntity> tq = em.createQuery("select u from UserEntity u join u.roles r where r.name = :roleName", UserEntity.class);
        tq.setParameter("roleName", "CLIENT");
        return tq.getResultList();
    }
}
