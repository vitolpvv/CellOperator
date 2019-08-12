package p.vitaly.celloperator.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfoDto {
    private Integer id;
    private Integer userId;
    private String birthday;
    private String passport;
    private String address;
    private String email;
}
