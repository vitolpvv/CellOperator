package p.vitaly.celloperator.dto.contract;

import lombok.Data;
import p.vitaly.celloperator.dto.Dto;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.dto.user.UserDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContractDto implements Dto {
    private Integer id;
    private String number;
    private TariffDto tariff;
    private List<OptionDto> options = new ArrayList<>();
    private boolean blocked;
    private UserDto blocker;
}
