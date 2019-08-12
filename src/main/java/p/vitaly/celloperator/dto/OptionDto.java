package p.vitaly.celloperator.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OptionDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal priceUse;
    private BigDecimal priceSet;
    private Integer payPeriodId;
    private String payPeriodName;
    private boolean permanent;
    private boolean archived;
    private Integer parentId;
    private List<OptionDto> children = new ArrayList<>();
}
