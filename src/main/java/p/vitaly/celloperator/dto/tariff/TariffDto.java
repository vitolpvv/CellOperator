package p.vitaly.celloperator.dto.tariff;

import lombok.Data;
import p.vitaly.celloperator.dto.Dto;
import p.vitaly.celloperator.dto.option.OptionDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class TariffDto implements Dto {
    private Integer id;
    private String name;
    private BigDecimal priceUse;
    private BigDecimal priceSet;
    private boolean archived;
    private List<OptionDto> options = new ArrayList<>();
}
