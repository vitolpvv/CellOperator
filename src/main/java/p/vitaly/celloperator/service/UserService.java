package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.dao.user.UserDao;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;
import p.vitaly.celloperator.service.converter.UserConverter;

@Service
public final class UserService extends ServiceImpl<UserEntity, UserDto> {

    @Autowired
    protected UserService(UserDao dao, UserConverter converter) {
        super(dao, converter);
    }
}
