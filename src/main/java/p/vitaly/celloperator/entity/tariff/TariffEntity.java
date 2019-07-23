package p.vitaly.celloperator.entity.tariff;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.option.OptionEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tariff", schema = "celloperator")
public class TariffEntity extends GeneratedIdEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price_use", nullable = false)
    private BigDecimal priceUse;

    @Column(name = "price_set")
    private BigDecimal priceSet;

    @Column(name = "archived")
    private boolean archived;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_has_option",
            joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private List<OptionEntity> options = new ArrayList<>();

    public void addOption(OptionEntity option) {
        options.add(option);
    }

    public void removeOption(OptionEntity option) {
        options.remove(option);
    }
}
