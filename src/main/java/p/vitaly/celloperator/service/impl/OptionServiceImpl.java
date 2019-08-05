package p.vitaly.celloperator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.vitaly.celloperator.converter.Converter;
import p.vitaly.celloperator.dao.Dao;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.service.OptionService;

@Service
public class OptionServiceImpl extends ServiceImpl<OptionEntity, OptionDto> implements OptionService {

    /**
     * Providing appropriate dao and 'db entity' <-> 'dto' converter on service creation.
     *
     * @param dao       - appropriate Doa instance.
     * @param converter - appropriate Converter instance.
     */
        @Autowired
    public OptionServiceImpl(Dao<OptionEntity, Integer> dao, Converter<OptionEntity, OptionDto> converter) {
        super(dao, converter);
    }
}
