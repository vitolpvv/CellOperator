package p.vitaly.celloperator.service;

import org.springframework.stereotype.Service;
import p.vitaly.celloperator.dao.contract.ContractDao;
import p.vitaly.celloperator.dto.contract.ContractDto;
import p.vitaly.celloperator.entity.contract.ContractEntity;
import p.vitaly.celloperator.service.converter.ContractConverter;

@Service
public class ContractService extends ServiceImpl<ContractEntity, ContractDto> {
    protected ContractService(ContractDao dao, ContractConverter converter) {
        super(dao, converter);
    }
}
