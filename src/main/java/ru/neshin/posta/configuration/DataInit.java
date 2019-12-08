package ru.neshin.posta.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.neshin.posta.dao.RoleDao;
import ru.neshin.posta.dao.UserDao;
import ru.neshin.posta.model.UserModel;
import ru.neshin.posta.model.UserRole;

@Component
@Data
public class DataInit implements ApplicationRunner {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userDao.count() == 0) {
            roleDao.deleteAll();
            UserRole userRole = new UserRole();
            userRole.setName("ADMIN");
            roleDao.save(userRole);
            UserModel user = new UserModel();
            user.setLogin("user");
            user.setName("First user");
            user.setPassword(new BCryptPasswordEncoder(11).encode("user"));
            user.setUserRole(userRole);
            userDao.save(user);
        }
    }
}
