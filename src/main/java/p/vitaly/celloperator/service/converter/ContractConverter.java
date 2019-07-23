package p.vitaly.celloperator.service.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.contract.ContractDto;
import p.vitaly.celloperator.entity.contract.ContractEntity;

@Component
public class ContractConverter implements Converter<ContractEntity, ContractDto> {
    @Override
    public ContractDto toDto(ContractEntity entity) {
        return null;
    }

    @Override
    public ContractEntity toEntity(ContractDto dto) {
        return null;
    }
}
