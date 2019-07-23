package p.vitaly.celloperator.dao.option;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.option.OptionIncompatibilityEntity;

@Repository
public class OptionIncompatibilityDao extends DaoImpl<OptionIncompatibilityEntity> {
    @Override
    protected Class<OptionIncompatibilityEntity> getEntityType() {
        return OptionIncompatibilityEntity.class;
    }
}
