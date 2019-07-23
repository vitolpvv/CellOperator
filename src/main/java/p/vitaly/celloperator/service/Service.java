package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.Dto;

import java.util.List;

public interface Service<T extends Dto, K> {
    void add(T dto);
    void update(T dto);
    void remove(T dto);
    T get(K id);
    List<T> getAll();
}
