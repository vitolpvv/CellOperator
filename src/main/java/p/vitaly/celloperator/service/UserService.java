package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;

@Service
@Transactional
public class UserService extends ServiceImpl<UserEntity, UserDto> {

    @Autowired
    protected UserService(Dao<UserEntity, Integer> dao, Converter<UserEntity, UserDto> converter) {
        super(dao, converter);
    }
}
