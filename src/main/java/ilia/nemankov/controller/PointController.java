package ilia.nemankov.controller;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping()
    public List<PointDTO> getPoints(@RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.getPoints(tokenHeader);
    }

    @PostMapping()
    public PointDTO addPoint(@RequestBody PointDTO point, @RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.addPoint(point, tokenHeader);
    }

}