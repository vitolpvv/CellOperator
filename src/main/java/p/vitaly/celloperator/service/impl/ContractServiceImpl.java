package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.ContractConverter;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dao.contract.ContractDao;
import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.dto.TariffDto;
import p.vitaly.celloperator.entity.contract.ContractEntity;
import p.vitaly.celloperator.service.ContractService;
import p.vitaly.celloperator.service.TariffService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl extends ServiceImpl<ContractEntity, ContractDto> implements ContractService {

    @Autowired
    private ContractDao dao;

    @Autowired
    private ContractConverter converter;

    @Autowired
    private TariffService tariffService;

    @Override
    Dao<ContractEntity, Integer> getDao() {
        return dao;
    }

    @Override
    Converter<ContractEntity, ContractDto> getConverter() {
        return converter;
    }

    @Override
    @Transactional
    public List<ContractDto> getContractsByUser(Integer userId) {
        return dao.getContractsByUser(userId).stream().map(contract -> converter.toDto(contract)).collect(Collectors.toList());
    }

    @Override
    public List<TariffDto> getAllTariffs() {
        return tariffService.getAllActive();
    }
}
