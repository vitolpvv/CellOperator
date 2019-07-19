package p.vitaly.celloperator.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
abstract class GeneratedIdEntity implements Serializable {

    @Id
    @GeneratedValue
    protected Integer id;

}
