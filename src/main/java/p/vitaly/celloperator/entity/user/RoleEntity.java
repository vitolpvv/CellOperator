package p.vitaly.celloperator.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import p.vitaly.celloperator.entity.GeneratedIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "role", schema = "celloperator")
public class RoleEntity extends GeneratedIdEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
