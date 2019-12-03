package ilia.nemankov.mapper;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User dtoToEntity(UserDTO dto) {
        User entity = new User();

        entity.setLogin(dto.getLogin());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        return entity;
    }

    public UserDTO entityToDTO(User entity) {
        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());

        return dto;
    }

}
