package p.vitaly.celloperator.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class TariffDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal priceUse;
    private BigDecimal priceSet;
    private Integer payPeriodId;
    private String payPeriodName;
    private boolean archived;
    private List<OptionDto> options = new ArrayList<>();
}
