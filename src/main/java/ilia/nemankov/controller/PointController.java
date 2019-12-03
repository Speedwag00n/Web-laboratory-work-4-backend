package ilia.nemankov.controller;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping(path = "/point")
    public PointDTO addPoint(@RequestBody PointDTO point) {
        return pointService.addPoint(point);
    }

}