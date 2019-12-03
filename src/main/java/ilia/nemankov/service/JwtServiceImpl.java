package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.model.User;
import ilia.nemankov.repository.UserRepository;
import ilia.nemankov.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtServiceImpl implements UserDetailsService, JwtService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User with login " + login + " not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    @Override
    public String authenticate(UserDTO user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
            UserDetails userDetails = loadUserByUsername(user.getLogin());
            String token = jwtTokenUtil.generateToken(userDetails);
            return token;
        } catch (DisabledException e) {
            throw e;
        } catch (BadCredentialsException e) {
            throw e;
        }
    }

}
