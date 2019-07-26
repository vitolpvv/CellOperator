package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;

@Component
public class UserConverter implements Converter<UserEntity, UserDto> {
    @Override
    public UserDto toDto(UserEntity entity) {
        return null;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        return null;
    }
}
