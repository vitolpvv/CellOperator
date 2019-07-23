package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.dto.Dto;
import p.vitaly.celloperator.entity.Entity;
import p.vitaly.celloperator.service.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ServiceImpl<T extends Entity, S extends Dto> implements Service<S, Integer> {

    private final DaoImpl<T> dao;
    private final Converter<T, S> converter;

    protected ServiceImpl(DaoImpl<T> dao, Converter<T, S> converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    public void add(S dto) {
        dao.add(converter.toEntity(dto));
    }

    @Override
    public void update(S dto) {
        dao.update(converter.toEntity(dto));
    }

    @Override
    public void remove(S dto) {
        dao.remove(converter.toEntity(dto));
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
