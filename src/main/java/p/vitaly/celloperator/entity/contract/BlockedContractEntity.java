package p.vitaly.celloperator.entity.contract;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "contract_blocked", schema = "celloperator")
public class BlockedContractEntity extends GeneratedIdEntity {

    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false, unique = true)
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "initiator_id", nullable = false)
    private UserEntity user;
}
