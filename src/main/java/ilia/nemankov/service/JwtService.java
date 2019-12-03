package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;

public interface JwtService {

    String authenticate(UserDTO user);

}
