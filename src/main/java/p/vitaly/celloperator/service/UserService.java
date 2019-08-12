package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.dto.user.UserDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

public interface UserService extends Service<UserDto, Integer> {
    List<UserDto> getAllClients();

    List<RoleDto> getAllRoles();

    List<ContractDto> getUserContracts(Integer userId);
}
