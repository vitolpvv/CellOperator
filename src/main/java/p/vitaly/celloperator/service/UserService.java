package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.user.UserDto;

import java.util.List;

public interface UserService extends Service<UserDto, Integer> {
    List<UserDto> getAllClients();
}
