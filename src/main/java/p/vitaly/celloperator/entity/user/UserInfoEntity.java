package p.vitaly.celloperator.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "user_info",schema = "celloperator")
public class UserInfoEntity extends GeneratedIdEntity {

    @Column(name = "birthday", nullable = false)
    private LocalDate bithday;

    @Column(name = "passport", nullable = false)
    private String passport;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
