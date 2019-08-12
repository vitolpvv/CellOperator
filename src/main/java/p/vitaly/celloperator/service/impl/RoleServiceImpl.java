package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.converter.RoleConverter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.user.RoleDao;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.entity.user.RoleEntity;
import p.vitaly.celloperator.service.RoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleEntity, RoleDto> implements RoleService {

    @Autowired
    private RoleDao dao;

    @Autowired
    private RoleConverter converter;

    @Override
    Dao<RoleEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<RoleEntity, RoleDto> getConverter() {
        return converter;
    }
}
