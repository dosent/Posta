package ru.neshin.posta.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.neshin.posta.model.UserModel;

@Repository
public interface UserDao  extends CrudRepository<UserModel, Long> {
    UserModel findByLoginAndEnabledAndPassword(String login, boolean enabled,String hash);
    UserModel findByLogin(String login);
}
