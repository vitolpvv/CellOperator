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

    @Override
    @Transactional
    public Integer add(S dto) {
        return getDao().add(getConverter().toEntity(dto));
    }

    @Override
    @Transactional
    public void update(S dto) {
        getDao().update(getConverter().toEntity(dto));
    }

    @Override
    @Transactional
    public Integer save(S dto) {
        return getDao().save(getConverter().toEntity(dto));
    }

    @Override
    @Transactional
    public void remove(S dto) {
        getDao().remove(getConverter().toEntity(dto));
    }

    @Override
    @Transactional
    public void removeWith(Integer id) {
        getDao().removeWith(id);
    }

    @Override
    @Transactional
    public S get(Integer id) {
        return getConverter().toDto(getDao().get(id));
    }

    @Override
    @Transactional
    public List<S> getAll() {
        List<S> dtos = new ArrayList<>();
        getDao().getAll().forEach(item -> dtos.add(getConverter().toDto(item)));
        return dtos;
    }

    abstract Dao<T, Integer> getDao();

    abstract Converter<T, S> getConverter();
}
