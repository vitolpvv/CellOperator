package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.converter.TariffConverter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.TariffDao;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.TariffDto;
import p.vitaly.celloperator.entity.TariffEntity;
import p.vitaly.celloperator.service.TariffService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TariffServiceImpl extends ServiceImpl<TariffEntity, TariffDto> implements TariffService {

    @Autowired
    private TariffDao dao;

    @Autowired
    private TariffConverter converter;

    @Autowired
    private p.vitaly.celloperator.service.Service<PaymentPeriodDto, Integer> paymentPeriodService;

    @Override
    Dao<TariffEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<TariffEntity, TariffDto> getConverter() {
        return converter;
    }

    @Override
    public List<TariffDto> getAllActive() {
        List<TariffDto> dtos = new ArrayList<>();
        dao.getAllActive().forEach(item -> dtos.add(converter.toDto(item)));
        return dtos;
    }

    @Override
    public List<PaymentPeriodDto> getPaymentPeriodAll() {
        return paymentPeriodService.getAll();
    }
}
