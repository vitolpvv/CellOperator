package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.entity.tariff.TariffEntity;

@Service
@Transactional
public class TariffService extends ServiceImpl<TariffEntity, TariffDto> {

    @Autowired
    public TariffService(Dao<TariffEntity, Integer> dao, Converter<TariffEntity, TariffDto> converter) {
        super(dao, converter);
    }
}
