package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.OptionDto;

import java.util.List;

public interface OptionService extends Service<OptionDto, Integer> {
    List<PaymentPeriodDto> getPaymentPeriodAll();
}
