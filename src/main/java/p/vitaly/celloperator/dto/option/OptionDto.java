package p.vitaly.celloperator.dto.option;

import lombok.Data;
import p.vitaly.celloperator.dto.Dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OptionDto implements Dto {
    private Integer id;
    private String name;
    private BigDecimal priceUse;
    private BigDecimal priseSet;
    private boolean archived;
    private List<OptionDto> children = new ArrayList<>();
}
