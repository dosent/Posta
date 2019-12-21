package ru.neshin.posta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.neshin.posta.model.UserModel;

@Service
public class UserDetails implements UserDetailsService {

    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetails.class);

    public UserDetails(UserService userService) {
        this.userService = userService;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.disabled(user.isEnabled());
        builder.roles(user.getUserRole().getName());

        return builder.build();
    }

}
