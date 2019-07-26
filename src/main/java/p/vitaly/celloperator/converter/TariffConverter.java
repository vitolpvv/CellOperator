package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.entity.tariff.TariffEntity;

@Component
public class TariffConverter implements Converter<TariffEntity, TariffDto> {
    @Override
    public TariffDto toDto(TariffEntity entity) {
        return null;
    }

    @Override
    public TariffEntity toEntity(TariffDto dto) {
        return null;
    }
}
