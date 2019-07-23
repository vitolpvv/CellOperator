package p.vitaly.celloperator.service.converter;

import p.vitaly.celloperator.dto.Dto;
import p.vitaly.celloperator.entity.Entity;

public interface Converter<T extends Entity, S extends Dto> {
    S toDto(T entity);

    T toEntity(S dto);
}
