package ilia.nemankov.service;

import ilia.nemankov.dto.UserDTO;
import ilia.nemankov.mapper.UserMapper;
import ilia.nemankov.model.User;
import ilia.nemankov.repository.UserRepository;
import ilia.nemankov.service.exception.LoginInUseException;
import org.hibernate.exception.ConstraintViolationException;
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
    public long addUser(UserDTO user) throws LoginInUseException {
        User entity = userMapper.dtoToEntity(user);
        Date registrationTime = new Date();
        entity.setLastLogout(registrationTime);
        try {
            long userId = userRepository.save(entity).getId();
            return userId;
        } catch (Throwable e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new LoginInUseException("Login isn't unique", e.getCause());
            } else {
                throw e;
            }
        }
    }

}
