package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.entity.user.RoleEntity;
import p.vitaly.celloperator.service.RoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleEntity, RoleDto> implements RoleService {

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    @Autowired
    public RoleServiceImpl(Dao<RoleEntity, Integer> dao, Converter<RoleEntity, RoleDto> converter) {
        super(dao, converter);
    }
}
