package p.vitaly.celloperator.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "role", schema = "celloperator")
public class RoleEntity extends GeneratedIdEntity implements Serializable {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();

    public void addUser(UserEntity user) {
        users.add(user);
        user.setRole(this);
    }

    public void removeUser(UserEntity user) {
        users.remove(user);
        user.setRole(null);
    }
}
