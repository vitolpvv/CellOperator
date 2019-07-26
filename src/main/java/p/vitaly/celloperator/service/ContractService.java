package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.contract.ContractDto;
import p.vitaly.celloperator.entity.contract.ContractEntity;

@Service
@Transactional
public class ContractService extends ServiceImpl<ContractEntity, ContractDto> {

    @Autowired
    public ContractService(Dao<ContractEntity, Integer> dao, Converter<ContractEntity, ContractDto> converter) {
        super(dao, converter);
    }
}
