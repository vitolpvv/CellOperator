package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;

@Service
@Transactional
public class OptionService extends ServiceImpl<OptionEntity, OptionDto> {

    @Autowired
    public OptionService(Dao<OptionEntity, Integer> dao, Converter<OptionEntity, OptionDto> converter) {
        super(dao, converter);
    }
}
