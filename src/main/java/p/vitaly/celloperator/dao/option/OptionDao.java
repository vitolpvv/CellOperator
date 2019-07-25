package p.vitaly.celloperator.dao.option;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.option.OptionEntity;

@Repository
public class OptionDao extends DaoImpl<OptionEntity> {

    public OptionDao() {
        super(OptionEntity.class);
    }
}
