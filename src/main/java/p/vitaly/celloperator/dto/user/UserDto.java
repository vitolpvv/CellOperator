package p.vitaly.celloperator.dto.user;

import lombok.Data;
import p.vitaly.celloperator.dto.Dto;
import p.vitaly.celloperator.dto.contract.ContractDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto implements Dto {
    private Integer id;
    private String firstname;
    private String lastname;
    private List<ContractDto> contracts = new ArrayList<>();
}
