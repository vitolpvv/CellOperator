package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.user.UserInfoDto;
import p.vitaly.celloperator.entity.user.UserEntity;
import p.vitaly.celloperator.entity.user.UserInfoEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserInfoConverter implements Converter<UserInfoEntity, UserInfoDto> {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public UserInfoDto toDto(UserInfoEntity entity) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(entity.getId());
        userInfoDto.setAddress(entity.getAddress());
        userInfoDto.setBirthday(entity.getBithday().format(formatter));
        userInfoDto.setEmail(entity.getEmail());
        userInfoDto.setPassport(entity.getPassport());
        if (entity.getUser() != null) userInfoDto.setUserId(entity.getUser().getId());
        return userInfoDto;
    }

    @Override
    public UserInfoEntity toEntity(UserInfoDto dto) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(dto.getId());
        userInfoEntity.setAddress(dto.getAddress());
        userInfoEntity.setEmail(dto.getEmail());
        userInfoEntity.setPassport(dto.getPassport());
        userInfoEntity.setBithday(LocalDate.parse(dto.getBirthday(), formatter));
        if (dto.getUserId() != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(dto.getUserId());
            userInfoEntity.setUser(userEntity);
        }
        return userInfoEntity;
    }
}
