package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.converter.PaymentPeriodConverter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.PaymentPeriodDao;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;
import p.vitaly.celloperator.service.PaymentPeriodService;

@Service
public class PaymentPeriodServiceImpl extends ServiceImpl<PaymentPeriodEntity, PaymentPeriodDto> implements PaymentPeriodService {

    @Autowired
    private PaymentPeriodDao dao;

    @Autowired
    private PaymentPeriodConverter converter;

    @Override
    Dao<PaymentPeriodEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<PaymentPeriodEntity, PaymentPeriodDto> getConverter() {
        return converter;
    }
}
