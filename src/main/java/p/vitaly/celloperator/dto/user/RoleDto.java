package p.vitaly.celloperator.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import p.vitaly.celloperator.dto.Dto;

@Data
@AllArgsConstructor
public class RoleDto implements Dto {
    private Integer id;
    private String name;
}
