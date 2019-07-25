package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.dao.user.RoleDao;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.entity.user.RoleEntity;
import p.vitaly.celloperator.service.converter.RoleConverter;

@Service
public class RoleService extends ServiceImpl<RoleEntity, RoleDto> {

    @Autowired
    public RoleService(RoleDao dao, RoleConverter converter) {
        super(dao, converter);
    }
}
