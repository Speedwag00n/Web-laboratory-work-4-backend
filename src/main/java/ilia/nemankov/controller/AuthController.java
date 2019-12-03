package ilia.nemankov.controller;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody UserDTO dto) {
        String token = jwtService.authenticate(dto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
