package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.entity.util.PaymentPeriodEntity;
import p.vitaly.celloperator.service.PaymentPeriodService;

@Service
public class PaymentPeriodServiceImpl extends ServiceImpl<PaymentPeriodEntity, PaymentPeriodDto> implements PaymentPeriodService {
    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    @Autowired
    protected PaymentPeriodServiceImpl(Dao<PaymentPeriodEntity, Integer> dao, Converter<PaymentPeriodEntity, PaymentPeriodDto> converter) {
        super(dao, converter);
    }
}
