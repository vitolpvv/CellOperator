package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.BlockedContractDto;
import p.vitaly.celloperator.entity.contract.BlockedContractEntity;
import p.vitaly.celloperator.entity.contract.ContractEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

@Component
public class BlockedContractConverter implements Converter<BlockedContractEntity, BlockedContractDto> {
    @Override
    public BlockedContractDto toDto(BlockedContractEntity entity) {
        BlockedContractDto blockedContractDto = new BlockedContractDto();
        blockedContractDto.setId(entity.getId());
        if (entity.getContract() != null) blockedContractDto.setContractId(entity.getContract().getId());
        if (entity.getUser() != null) blockedContractDto.setUserId(entity.getUser().getId());
        return blockedContractDto;
    }

    @Override
    public BlockedContractEntity toEntity(BlockedContractDto dto) {
        BlockedContractEntity blockedContractEntity = new BlockedContractEntity();
        blockedContractEntity.setId(dto.getId());
        if (dto.getContractId() != null) {
            ContractEntity contractEntity = new ContractEntity();
            contractEntity.setId(dto.getContractId());
            blockedContractEntity.setContract(contractEntity);
        }
        if (dto.getUserId() != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(dto.getUserId());
            blockedContractEntity.setUser(userEntity);
        }
        return blockedContractEntity;
    }
}
