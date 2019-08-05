package p.vitaly.celloperator.dto.user;

import lombok.Data;
import p.vitaly.celloperator.dto.contract.ContractDto;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String login;
    private boolean blocked;
    private RoleDto role;
    private UserInfoDto userInfo;
    private List<ContractDto> contracts;
}
