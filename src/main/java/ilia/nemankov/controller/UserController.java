package ilia.nemankov.controller;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> register(@RequestBody UserDTO dto) {
        long id = userService.addUser(dto);
        //TODO return token
        return new ResponseEntity<>(id + "", HttpStatus.OK);
    }

}
