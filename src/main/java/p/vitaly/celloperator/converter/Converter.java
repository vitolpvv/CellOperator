package p.vitaly.celloperator.converter;

/**
 * Interface for conversion 'db entity' <-> 'dto'.
 * @param <T> - 'db entity' class.
 * @param <S> - 'dto' class.
 */
public interface Converter<T, S> {
    S toDto(T entity);
    T toEntity(S dto);
}
