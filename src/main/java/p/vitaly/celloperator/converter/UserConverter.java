package p.vitaly.celloperator.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.RoleEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

@Component
public class UserConverter implements Converter<UserEntity, UserDto> {
    @Autowired
    private UserInfoConverter userInfoConverter;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setFirstName(entity.getFirstname());
        userDto.setLastName(entity.getLastname());
        userDto.setBlocked(entity.isBlocked());
        if (entity.getInfo() != null) userDto.setUserInfo(userInfoConverter.toDto(entity.getInfo()));
        entity.getRoles().forEach(role -> userDto.getRoleIds().add(role.getId()));
        return userDto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getId());
        userEntity.setFirstname(dto.getFirstName());
        userEntity.setLastname(dto.getLastName());
        userEntity.setBlocked(dto.isBlocked());
        userEntity.setInfo(userInfoConverter.toEntity(dto.getUserInfo()));
        dto.getRoleIds().forEach(roleId -> {
            RoleEntity role = new RoleEntity();
            role.setId(roleId);
            userEntity.getRoles().add(role);
        });
        return userEntity;
    }
}
