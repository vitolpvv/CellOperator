package p.vitaly.celloperator.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfoDto {
    private Integer id;
    private UserDto user;
    private LocalDate birthday;
    private String passport;
    private String address;
    private String email;
}
