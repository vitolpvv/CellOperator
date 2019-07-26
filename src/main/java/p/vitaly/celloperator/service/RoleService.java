package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.entity.user.RoleEntity;

@Service
@Transactional
public class RoleService extends ServiceImpl<RoleEntity, RoleDto> {

    @Autowired
    public RoleService(Dao<RoleEntity, Integer> dao, Converter<RoleEntity, RoleDto> converter) {
        super(dao, converter);
    }
}
