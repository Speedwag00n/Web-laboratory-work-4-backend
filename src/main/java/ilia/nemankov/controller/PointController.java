package ilia.nemankov.controller;

import ilia.nemankov.dto.PointDTO;
import ilia.nemankov.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping(path = "/point")
    public List<PointDTO> getPoints(@RequestParam(value = "r") @Max(3) @Min(1) double currentRadius, @RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.getPoints(currentRadius, tokenHeader);
    }

    @PostMapping(path = "/point")
    public PointDTO addPoint(@Validated @RequestBody PointDTO point, @RequestHeader(value = "Authorization") String tokenHeader) {
        return pointService.addPoint(point, tokenHeader);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}