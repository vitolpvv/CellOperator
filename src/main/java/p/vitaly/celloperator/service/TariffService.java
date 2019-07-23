package p.vitaly.celloperator.service;

import org.springframework.stereotype.Service;
import p.vitaly.celloperator.dao.tariff.TariffDao;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.entity.tariff.TariffEntity;
import p.vitaly.celloperator.service.converter.TariffConverter;

@Service
public final class TariffService extends ServiceImpl<TariffEntity, TariffDto> {

    protected TariffService(TariffDao dao, TariffConverter converter) {
        super(dao, converter);
    }
}
