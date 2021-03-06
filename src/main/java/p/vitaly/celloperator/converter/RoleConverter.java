package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.entity.user.RoleEntity;

@Component
public class RoleConverter implements Converter<RoleEntity, RoleDto> {
    @Override
    public RoleDto toDto(RoleEntity entity) {
        return new RoleDto(entity.getId(), entity.getName());
    }

    @Override
    public RoleEntity toEntity(RoleDto dto) {
        RoleEntity role = new RoleEntity();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
