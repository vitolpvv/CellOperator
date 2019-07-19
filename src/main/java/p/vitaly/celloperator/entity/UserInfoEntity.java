package p.vitaly.celloperator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "user_info",schema = "celloperator")
class UserInfoEntity extends GeneratedIdEntity implements Serializable {

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
