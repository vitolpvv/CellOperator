package p.vitaly.celloperator.dao.util;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.dao.DaoImpl;
import p.vitaly.celloperator.entity.util.PaymentPeriodEntity;

@Repository
public class PaymentPeriodDao extends DaoImpl<PaymentPeriodEntity> {

    protected PaymentPeriodDao() {
        super(PaymentPeriodEntity.class);
    }
}
