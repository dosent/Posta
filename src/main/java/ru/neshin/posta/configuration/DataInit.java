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
import ru.neshin.posta.service.schedules.ScheduledTasks;

import java.util.Date;

@Component
@Data
public class DataInit implements ApplicationRunner {

    private UserDao userDao;

    private RoleDao roleDao;

    private ScheduledTasks scheduledTasks;

    @Autowired
    public DataInit(UserDao userDao, RoleDao roleDao, ScheduledTasks scheduledTasks) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.scheduledTasks = scheduledTasks;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userDao.count() == 0) {
            roleDao.deleteAll();
            UserRole userRole = new UserRole();
            userRole.setName("ADMIN");
            roleDao.save(userRole);
            UserModel user = new UserModel();
            user.setLogin("user");
            user.setName("First user. create: " + (new Date()).toString());
            user.setPassword(new BCryptPasswordEncoder(11).encode("user"));
            user.setUserRole(userRole);
            userDao.save(user);
        }
        scheduledTasks.reportCurrentTime();
    }
}
