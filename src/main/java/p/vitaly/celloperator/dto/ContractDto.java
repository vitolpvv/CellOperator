package p.vitaly.celloperator.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ContractDto implements Serializable {
    private Integer id;
    private String number;
    private Integer userId;
    private Integer tariffId;
    private List<OptionDto> options = new ArrayList<>();
    private boolean blocked;
    private BlockedContractDto blocker;
}
