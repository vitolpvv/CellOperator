package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.dao.option.OptionDao;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.converter.OptionConverter;

@Service
@Transactional
public class OptionService extends ServiceImpl<OptionEntity, OptionDto> {

    @Autowired
    public OptionService(OptionDao dao, OptionConverter converter) {
        super(dao, converter);
    }
}
