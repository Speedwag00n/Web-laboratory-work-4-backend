package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface JwtService {

    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    String authenticate(UserDTO user);

}
