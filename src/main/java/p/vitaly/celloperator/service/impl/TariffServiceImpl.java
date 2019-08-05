package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.tariff.TariffDao;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.entity.tariff.TariffEntity;
import p.vitaly.celloperator.service.TariffService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TariffServiceImpl extends ServiceImpl<TariffEntity, TariffDto> implements TariffService {

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    @Autowired
    public TariffServiceImpl(Dao<TariffEntity, Integer> dao, Converter<TariffEntity, TariffDto> converter) {
        super(dao, converter);
    }

    @Override
    public List<TariffDto> getAllActive() {
        List<TariffDto> dtos = new ArrayList<>();
        ((TariffDao)dao).getAllActive().forEach(item -> dtos.add(converter.toDto(item)));
        return dtos;
    }
}
