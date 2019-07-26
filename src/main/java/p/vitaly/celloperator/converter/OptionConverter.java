package p.vitaly.celloperator.converter;

import org.springframework.stereotype.Component;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;

@Component
public class OptionConverter implements Converter<OptionEntity, OptionDto> {
    @Override
    public OptionDto toDto(OptionEntity entity) {
        return null;
    }

    @Override
    public OptionEntity toEntity(OptionDto dto) {
        return null;
    }
}
