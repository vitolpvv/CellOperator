package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tariff", schema = "celloperator")
class TariffEntity extends GeneratedIdEntity implements Serializable {

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
