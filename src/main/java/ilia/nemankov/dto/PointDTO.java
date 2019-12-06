package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class PointDTO {

    @NotNull
    @Max(3)
    @Min(-5)
    private Integer x;

    @NotNull
    @Max(5)
    @Min(-5)
    private Double y;

    @NotNull
    @Max(5)
    @Min(-3)
    private Integer r;

    @Null
    private Boolean hit;

    @Null
    private Boolean hitNow;

}
