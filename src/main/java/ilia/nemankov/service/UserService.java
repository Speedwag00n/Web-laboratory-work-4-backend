package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.service.exception.LoginInUseException;

public interface UserService {

    long addUser(UserDTO user) throws LoginInUseException;

}
