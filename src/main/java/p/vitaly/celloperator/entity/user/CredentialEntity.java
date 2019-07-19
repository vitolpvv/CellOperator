package p.vitaly.celloperator.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "credential", schema = "celloperator")
public class CredentialEntity extends GeneratedIdEntity implements Serializable {

    @Column(name = "pwd_md5", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
