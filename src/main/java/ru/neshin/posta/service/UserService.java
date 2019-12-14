package ru.neshin.posta.service;

import dto.UserDto;
import ru.neshin.posta.service.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neshin.posta.configuration.PostaRunTimeException;
import ru.neshin.posta.dao.UserDao;
import ru.neshin.posta.model.UserModel;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<UserDto> getAllUsers(){
        List<UserModel> allUsers = (List<UserModel>) userDao.findAll();
        List<UserDto> userDtos;
        try {
            userDtos = UserMapper.INSTANCE.userToUserDto(allUsers);
        } catch (Throwable t) {
            LOGGER.error("Error UserService.getAllUsers()",t);
            throw new PostaRunTimeException();
        };
        return userDtos;
    }

    public boolean isEnableLogin(String login, String hashPassword) {
        return userDao.findByLoginAndEnabledAndPassword(login, true, hashPassword) != null;
    }

    @Transactional
    public UserModel findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
