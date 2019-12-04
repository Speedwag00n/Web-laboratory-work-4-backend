package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDTO {

    private long id;
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private boolean hitNow;

}
