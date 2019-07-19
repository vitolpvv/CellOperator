package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "contact_blocked", schema = "celloperator")
class BlockedContractEntity extends GeneratedIdEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false, unique = true)
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
