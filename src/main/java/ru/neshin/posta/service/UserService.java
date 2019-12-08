package ru.neshin.posta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neshin.posta.dao.UserDao;
import ru.neshin.posta.model.UserModel;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public List<UserModel> getAllUsers(){
        return (List<UserModel>) userDao.findAll();
    }

    public boolean isEnableLogin(String login, String hashPassword) {
        return userDao.findByLoginAndEnabledAndPassword(login, true, hashPassword) != null;
    }

    @Transactional
    public UserModel findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
