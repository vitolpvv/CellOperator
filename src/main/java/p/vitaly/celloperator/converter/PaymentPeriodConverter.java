package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;

@Component
public class PaymentPeriodConverter implements Converter<PaymentPeriodEntity, PaymentPeriodDto> {
    @Override
    public PaymentPeriodDto toDto(PaymentPeriodEntity entity) {
        PaymentPeriodDto periodDto = new PaymentPeriodDto();
        periodDto.setId(entity.getId());
        periodDto.setName(entity.getName());
        return periodDto;
    }

    @Override
    public PaymentPeriodEntity toEntity(PaymentPeriodDto dto) {
        PaymentPeriodEntity periodEntity = new PaymentPeriodEntity();
        periodEntity.setId(dto.getId());
        periodEntity.setName(dto.getName());
        return periodEntity;
    }
}
