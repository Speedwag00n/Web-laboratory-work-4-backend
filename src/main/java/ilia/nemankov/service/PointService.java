package ilia.nemankov.service;

import ilia.nemankov.dto.PointDTO;

import java.util.List;

public interface PointService {

    List<PointDTO> getPoints(double currentRadius, String tokenHeader);

    PointDTO addPoint(PointDTO point, String tokenHeader);

}
