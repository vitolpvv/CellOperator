package p.vitaly.celloperator.entity.contract;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.TariffEntity;
import p.vitaly.celloperator.entity.option.OptionEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "contract", schema = "celloperator")
public class ContractEntity extends GeneratedIdEntity {

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private TariffEntity tariff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private BlockedContractEntity blocker;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contract_has_option",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<OptionEntity> options = new HashSet<>();
}
