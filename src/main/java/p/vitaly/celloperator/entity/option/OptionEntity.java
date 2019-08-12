package p.vitaly.celloperator.entity.option;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.NameDescription;
import p.vitaly.celloperator.entity.PaymentPeriodEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tariff_option", schema = "celloperator")
public class OptionEntity extends GeneratedIdEntity {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(
                    name = "name",
                    column = @Column(name = "name", nullable = false, unique = true)
            ),
            @AttributeOverride(
                    name = "description",
                    column = @Column(name = "description")
            )}
    )
    private NameDescription nameDescription;

    @Column(name = "price_use", nullable = false)
    private BigDecimal priceUse;

    @Column(name = "price_set")
    private BigDecimal priceSet;

    @Column(name = "permanent")
    private boolean permanent;

    @Column(name = "archived")
    private boolean archived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_option_id")
    private OptionEntity parent;

    @ManyToOne
    @JoinColumn(name = "payment_period_id")
    private PaymentPeriodEntity paymentPeriod;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OptionEntity> children = new HashSet<>();

    public void addChild(OptionEntity option) {
        children.add(option);
        option.setParent(option);
    }

    public void removeChild(OptionEntity option) {
        children.remove(option);
        option.setParent(null);
    }
}
