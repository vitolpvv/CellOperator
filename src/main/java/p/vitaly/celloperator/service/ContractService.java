package p.vitaly.celloperator.service;

import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.dto.TariffDto;

import java.util.List;

public interface ContractService extends Service<ContractDto, Integer> {
    List<ContractDto> getContractsByUser(Integer userId);

    List<TariffDto> getAllTariffs();
}
