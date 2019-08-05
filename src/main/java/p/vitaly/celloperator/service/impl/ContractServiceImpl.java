package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.contract.ContractDto;
import p.vitaly.celloperator.entity.contract.ContractEntity;

@Service
public class ContractServiceImpl extends ServiceImpl<ContractEntity, ContractDto> {

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
    @Autowired
    public ContractServiceImpl(Dao<ContractEntity, Integer> dao, Converter<ContractEntity, ContractDto> converter) {
        super(dao, converter);
    }
}
