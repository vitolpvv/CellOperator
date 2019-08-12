package p.vitaly.celloperator.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.entity.TariffEntity;
import p.vitaly.celloperator.entity.contract.BlockedContractEntity;
import p.vitaly.celloperator.entity.contract.ContractEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

@Component
public class ContractConverter implements Converter<ContractEntity, ContractDto> {
    @Autowired
    private OptionConverter optionConverter;

    @Autowired
    private BlockedContractConverter blockedContractConverter;

    @Override
    public ContractDto toDto(ContractEntity entity) {
        ContractDto contractDto = new ContractDto();
        contractDto.setId(entity.getId());
        contractDto.setNumber(entity.getNumber());
        if (entity.getUser() != null) contractDto.setUserId(entity.getUser().getId());
        if (entity.getTariff() != null)contractDto.setTariffId(entity.getTariff().getId());
        if (entity.getBlocker() != null) {
            contractDto.setBlocked(true);
            contractDto.setBlocker(blockedContractConverter.toDto(entity.getBlocker()));
        }
        entity.getOptions().forEach(optionEntity -> contractDto.getOptions().add(optionConverter.toDto(optionEntity)));
        return contractDto;
    }

    @Override
    public ContractEntity toEntity(ContractDto dto) {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setId(dto.getId());
        contractEntity.setNumber(dto.getNumber());
        if (dto.getUserId() != null) {
            UserEntity user = new UserEntity();
            user.setId(dto.getUserId());
            contractEntity.setUser(user);
        }
        if (dto.getTariffId() != null) {
            TariffEntity tariff = new TariffEntity();
            tariff.setId(dto.getTariffId());
            contractEntity.setTariff(tariff);
        }
        if (dto.isBlocked()) {
            contractEntity.setBlocker(blockedContractConverter.toEntity(dto.getBlocker()));
        }
        dto.getOptions().forEach(option -> contractEntity.getOptions().add(optionConverter.toEntity(option)));
        return contractEntity;
    }
}
