package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class PointDTO implements Serializable {

    private static final long serialVersionUID = 3901366814622766639L;

    @NotNull
    @Max(3)
    @Min(-5)
    private Double x;

    @NotNull
    @DecimalMax(value = "5", inclusive = false)
    @DecimalMin(value = "-5", inclusive = false)
    private Double y;

    @NotNull
    @Max(3)
    @Min(1)
    private Integer r;

    @Null
    private Boolean hit;

    @Null
    private Boolean hitNow;

}
