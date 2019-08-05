package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.user.UserDao;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;
import p.vitaly.celloperator.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserEntity, UserDto> implements UserService {

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    @Autowired
    protected UserServiceImpl(Dao<UserEntity, Integer> dao, Converter<UserEntity, UserDto> converter) {
        super(dao, converter);
    }

    @Override
    public List<UserDto> getAllClients() {
        List<UserDto> dtos = new ArrayList<>();
        ((UserDao)dao).getAllClients().forEach(item -> dtos.add(converter.toDto(item)));
        return dtos;
    }
}
