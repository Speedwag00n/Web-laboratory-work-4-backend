package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PointDTO {

    @NotNull
    private double x;

    @NotNull
    private double y;

    @NotNull
    private double r;

    private boolean hit;

    private boolean hitNow;

}
