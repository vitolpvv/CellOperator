package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.TariffDto;

import java.util.List;

public interface TariffService extends Service<TariffDto, Integer> {
    List<TariffDto> getAllActive();
    List<PaymentPeriodDto> getPaymentPeriodAll();
}
