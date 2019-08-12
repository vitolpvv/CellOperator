package p.vitaly.celloperator.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.TariffDto;
import p.vitaly.celloperator.entity.TariffEntity;
import p.vitaly.celloperator.entity.NameDescription;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;

@Component
public class TariffConverter implements Converter<TariffEntity, TariffDto> {
    @Autowired
    private OptionConverter optionConverter;

    @Override
    public TariffDto toDto(TariffEntity entity) {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(entity.getId());
        tariffDto.setName(entity.getNameDescription().getName());
        tariffDto.setDescription(entity.getNameDescription().getDescription());
        tariffDto.setPriceSet(entity.getPriceSet());
        tariffDto.setPriceUse(entity.getPriceUse());
        tariffDto.setArchived(entity.isArchived());
        if (entity.getPaymentPeriod() != null) {
            tariffDto.setPayPeriodId(entity.getPaymentPeriod().getId());
            tariffDto.setPayPeriodName(entity.getPaymentPeriod().getName());
        }
        entity.getOptions().forEach(item -> tariffDto.getOptions().add(optionConverter.toDto(item)));
        return tariffDto;
    }

    @Override
    public TariffEntity toEntity(TariffDto dto) {
        TariffEntity tariffEntity = new TariffEntity();
        tariffEntity.setId(dto.getId());
        tariffEntity.setNameDescription(new NameDescription(dto.getName(), dto.getDescription()));
        tariffEntity.setPriceSet(dto.getPriceSet());
        tariffEntity.setPriceUse(dto.getPriceUse());
        tariffEntity.setArchived(dto.isArchived());
        if (dto.getPayPeriodId() != null) {
            PaymentPeriodEntity paymentPeriodEntity = new PaymentPeriodEntity();
            paymentPeriodEntity.setId(dto.getPayPeriodId());
            tariffEntity.setPaymentPeriod(paymentPeriodEntity);
        }
        dto.getOptions().forEach(item -> tariffEntity.addOption(optionConverter.toEntity(item)));
        return tariffEntity;
    }
}
