package p.vitaly.celloperator.dto.user;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private boolean blocked;
    private UserInfoDto userInfo = new UserInfoDto();
    private Set<Integer> roleIds = new HashSet<>();
}
