package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.mapper.UserMapper;
import ilia.nemankov.model.User;
import ilia.nemankov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public long addUser(UserDTO user) {
        User entity = userMapper.dtoToEntity(user);
        Date registrationTime = new Date();
        entity.setLastLogout(registrationTime);
        long userId = userRepository.save(entity).getId();
        return userId;
    }

}
