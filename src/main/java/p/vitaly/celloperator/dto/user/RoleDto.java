package p.vitaly.celloperator.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RoleDto implements Serializable {
    private Integer id;
    private String name;
}
