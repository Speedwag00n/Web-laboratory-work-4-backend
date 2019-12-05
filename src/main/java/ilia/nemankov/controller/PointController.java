package ilia.nemankov.controller;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping(path = "/point")
    public List<PointDTO> getPoints(@RequestParam(value = "r", required = false) double currentRadius, @RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.getPoints(currentRadius, tokenHeader);
    }

    @PostMapping(path = "/point")
    public PointDTO addPoint(@RequestBody PointDTO point, @RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.addPoint(point, tokenHeader);
    }

}