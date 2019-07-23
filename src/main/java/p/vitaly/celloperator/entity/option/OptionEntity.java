package p.vitaly.celloperator.entity.option;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "option", schema = "celloperator")
public class OptionEntity extends GeneratedIdEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price_use", nullable = false)
    private BigDecimal priceUse;

    @Column(name = "price_set")
    private BigDecimal priceSet;

    @Column(name = "archived")
    private boolean archived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_option_id")
    private OptionEntity parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OptionEntity> children = new ArrayList<>();

    public void addChild(OptionEntity option) {
        children.add(option);
        option.setParent(option);
    }

    public void removeChild(OptionEntity option) {
        children.remove(option);
        option.setParent(null);
    }
}
