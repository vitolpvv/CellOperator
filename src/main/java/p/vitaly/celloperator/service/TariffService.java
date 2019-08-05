package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.tariff.TariffDto;

import java.util.List;

public interface TariffService extends Service<TariffDto, Integer> {
    List<TariffDto> getAllActive();
}
