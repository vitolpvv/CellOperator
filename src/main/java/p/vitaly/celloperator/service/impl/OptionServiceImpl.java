package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.converter.OptionConverter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.option.OptionDao;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.service.OptionService;

import java.util.List;

@Service
public class OptionServiceImpl extends ServiceImpl<OptionEntity, OptionDto> implements OptionService {

    @Autowired
    private OptionDao dao;

    @Autowired
    private OptionConverter converter;

    @Autowired
    private p.vitaly.celloperator.service.Service<PaymentPeriodDto, Integer> paymentPeriodService;

    @Override
    Dao<OptionEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<OptionEntity, OptionDto> getConverter() {
        return converter;
    }

    @Override
    public List<PaymentPeriodDto> getPaymentPeriodAll() {
        return paymentPeriodService.getAll();
    }
}
