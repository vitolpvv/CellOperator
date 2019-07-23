package p.vitaly.celloperator.entity.option;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "option_incompatibility", schema = "celloperator")
public class OptionIncompatibilityEntity extends GeneratedIdEntity {

    @ManyToOne
    @JoinColumn(name = "option1_id", nullable = false)
    private OptionEntity option1;

    @ManyToOne
    @JoinColumn(name = "option2_id", nullable = false)
    private OptionEntity option2;
}
