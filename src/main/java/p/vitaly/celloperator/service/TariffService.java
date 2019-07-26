package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.dao.tariff.TariffDao;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.entity.tariff.TariffEntity;
import p.vitaly.celloperator.converter.TariffConverter;

@Service
@Transactional
public class TariffService extends ServiceImpl<TariffEntity, TariffDto> {

    @Autowired
    public TariffService(TariffDao dao, TariffConverter converter) {
        super(dao, converter);
    }
}
