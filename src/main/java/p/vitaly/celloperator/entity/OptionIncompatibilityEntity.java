package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "option_incompatibility", schema = "celloperator")
public class OptionIncompatibilityEntity extends GeneratedIdEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "option1_id", nullable = false)
    private OptionEntity option1;

    @ManyToOne
    @JoinColumn(name = "option2_id", nullable = false)
    private OptionEntity option2;
}
