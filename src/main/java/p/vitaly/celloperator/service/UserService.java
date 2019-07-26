package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.dao.user.UserDao;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;
import p.vitaly.celloperator.converter.UserConverter;

@Service
@Transactional
public class UserService extends ServiceImpl<UserEntity, UserDto> {

    @Autowired
    protected UserService(UserDao dao, UserConverter converter) {
        super(dao, converter);
    }
}
