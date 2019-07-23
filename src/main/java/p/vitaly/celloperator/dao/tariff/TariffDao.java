package p.vitaly.celloperator.dao.tariff;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.tariff.TariffEntity;

@Repository
public class TariffDao extends DaoImpl<TariffEntity> {
    @Override
    protected Class<TariffEntity> getEntityType() {
        return TariffEntity.class;
    }
}
