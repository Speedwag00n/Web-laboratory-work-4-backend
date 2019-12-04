package ilia.nemankov.controller;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.service.JwtService;
import ilia.nemankov.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody UserDTO dto) {
        String token = jwtService.login(dto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping(path = "/logout")
    public ResponseEntity logout(@RequestHeader(value = "Authorization") String tokenHeader) {
        String token = jwtUtil.getTokenFromHeader(tokenHeader);
        String login = jwtUtil.getUsernameFromToken(token);

        jwtService.logout(login);

        return new ResponseEntity(HttpStatus.OK);
    }

}
