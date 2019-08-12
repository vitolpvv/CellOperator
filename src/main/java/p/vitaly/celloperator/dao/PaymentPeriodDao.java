package p.vitaly.celloperator.dao;

import org.springframework.stereotype.Repository;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;

@Repository
public class PaymentPeriodDao extends DaoImpl<PaymentPeriodEntity> {

    protected PaymentPeriodDao() {
        super(PaymentPeriodEntity.class);
    }
}
