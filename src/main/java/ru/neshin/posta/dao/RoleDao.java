package ru.neshin.posta.dao;

import org.springframework.data.repository.CrudRepository;
import ru.neshin.posta.model.UserRole;

public interface RoleDao extends CrudRepository<UserRole, Long> {
}
