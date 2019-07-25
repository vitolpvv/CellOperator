package p.vitaly.celloperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.vitaly.celloperator.dao.option.OptionDao;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.service.converter.OptionConverter;

@Service
public class OptionService extends ServiceImpl<OptionEntity, OptionDto> {

    @Autowired
    public OptionService(OptionDao dao, OptionConverter converter) {
        super(dao, converter);
    }
}
