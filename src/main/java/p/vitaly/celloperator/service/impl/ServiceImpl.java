package p.vitaly.celloperator.service.impl;

import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic Service implementation with Integer 'id'.
 * @param <T> - 'db entity' class.
 * @param <S> - 'dto' class.
 */
public abstract class ServiceImpl<T, S> implements Service<S, Integer> {

    protected Dao<T, Integer> dao;
    protected Converter<T, S> converter;

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     * @param dao - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    protected ServiceImpl(Dao<T, Integer> dao, Converter<T, S> converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    @Transactional
    public Integer add(S dto) {
        return dao.add(converter.toEntity(dto));
    }

    @Override
    @Transactional
    public void update(S dto) {
        dao.update(converter.toEntity(dto));
    }

    @Override
    @Transactional
    public void remove(S dto) {
        dao.remove(converter.toEntity(dto));
    }

    @Override
    @Transactional
    public void removeWith(Integer id) {
        dao.removeWith(id);
    }

    @Override
    public S get(Integer id) {
        return converter.toDto(dao.get(id));
    }

    @Override
    public List<S> getAll() {
        List<S> dtos = new ArrayList<>();
        dao.getAll().forEach(item -> dtos.add(converter.toDto(item)));
        return dtos;
    }
}
