package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.option.OptionEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tariff", schema = "celloperator")
public class TariffEntity extends GeneratedIdEntity {

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

    @ManyToOne
    @JoinColumn(name = "payment_period_id")
    private PaymentPeriodEntity paymentPeriod;

    @Column(name = "price_set")
    private BigDecimal priceSet;

    @Column(name = "archived")
    private boolean archived;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_has_option",
            joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<OptionEntity> options = new HashSet<>();

    public void addOption(OptionEntity option) {
        options.add(option);
    }

    public void removeOption(OptionEntity option) {
        options.remove(option);
    }
}
