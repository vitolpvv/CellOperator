package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.converter.UserConverter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.user.UserDao;
import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.entity.user.UserEntity;
import p.vitaly.celloperator.service.ContractService;
import p.vitaly.celloperator.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserEntity, UserDto> implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private UserConverter converter;

    @Autowired
    private p.vitaly.celloperator.service.Service<RoleDto, Integer> roleService;

    @Autowired
    private ContractService contractService;

    @Override
    Dao<UserEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<UserEntity, UserDto> getConverter() {
        return converter;
    }

    @Override
    public List<UserDto> getAllClients() {
        List<UserDto> dtos = new ArrayList<>();
        dao.getAllClients().forEach(item -> dtos.add(converter.toDto(item)));
        return dtos;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleService.getAll();
    }

    @Override
    public List<ContractDto> getUserContracts(Integer userId) {
        return contractService.getContractsByUser(userId);
    }
}
