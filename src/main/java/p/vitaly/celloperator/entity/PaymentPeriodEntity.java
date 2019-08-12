package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "payment_period", schema = "celloperator")
public class PaymentPeriodEntity extends GeneratedIdEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
