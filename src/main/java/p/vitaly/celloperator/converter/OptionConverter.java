package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.entity.NameDescription;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;

import java.util.stream.Collectors;

@Component
public class OptionConverter implements Converter<OptionEntity, OptionDto> {

    @Override
    public OptionDto toDto(OptionEntity entity) {
        OptionDto optionDto = new OptionDto();
        optionDto.setId(entity.getId());
        optionDto.setName(entity.getNameDescription().getName());
        optionDto.setDescription(entity.getNameDescription().getDescription());
        optionDto.setPriceUse(entity.getPriceUse());
        optionDto.setPriceSet(entity.getPriceSet());
        if (entity.getPaymentPeriod() != null) {
            optionDto.setPayPeriodId(entity.getPaymentPeriod().getId());
            optionDto.setPayPeriodName(entity.getPaymentPeriod().getName());
        }
        optionDto.setPermanent(entity.isPermanent());
        optionDto.setArchived(entity.isArchived());
        if (entity.getParent() != null)
            optionDto.setParentId(entity.getParent().getId());
        optionDto.setChildren(entity.getChildren().stream().map(this::toDto).collect(Collectors.toList()));
        return optionDto;
    }

    @Override
    public OptionEntity toEntity(OptionDto dto) {
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setId(dto.getId());
        optionEntity.setNameDescription(new NameDescription(dto.getName(), dto.getDescription()));
        optionEntity.setPriceUse(dto.getPriceUse());
        optionEntity.setPriceSet(dto.getPriceSet());
        if (dto.getPayPeriodId() != null) {
            PaymentPeriodEntity paymentPeriodEntity = new PaymentPeriodEntity();
            paymentPeriodEntity.setId(dto.getPayPeriodId());
            optionEntity.setPaymentPeriod(paymentPeriodEntity);
        }
        optionEntity.setPermanent(dto.isPermanent());
        optionEntity.setArchived(dto.isArchived());
        if (dto.getParentId() != null) {
            OptionEntity parent = new OptionEntity();
            parent.setId(dto.getParentId());
            optionEntity.setParent(parent);
        }
        dto.getChildren().forEach(item -> optionEntity.addChild(this.toEntity(item)));
        return optionEntity;
    }
}
