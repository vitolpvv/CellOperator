package p.vitaly.celloperator.entity.contract;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.entity.tariff.TariffEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "contract", schema = "celloperator")
public class ContractEntity extends GeneratedIdEntity implements Serializable {

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private TariffEntity tariff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "contract_has_option",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private List<OptionEntity> options = new ArrayList<>();
}
