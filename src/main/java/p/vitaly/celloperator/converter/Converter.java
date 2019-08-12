package p.vitaly.celloperator.converter;

import com.sun.istack.NotNull;

/**
 * Interface for conversion 'db entity' <-> 'dto'.
 * @param <T> - 'db entity' class.
 * @param <S> - 'dto' class.
 */
public interface Converter<T, S> {
    S toDto(@NotNull T entity);
    T toEntity(@NotNull S dto);
}
