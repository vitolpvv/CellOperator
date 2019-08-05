package p.vitaly.celloperator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentPeriodDto implements Serializable {
    private Integer id;
    private String name;
}
