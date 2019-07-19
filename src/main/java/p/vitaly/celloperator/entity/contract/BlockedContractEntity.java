package p.vitaly.celloperator.entity.contract;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;
import p.vitaly.celloperator.entity.user.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "contact_blocked", schema = "celloperator")
public class BlockedContractEntity extends GeneratedIdEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false, unique = true)
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
