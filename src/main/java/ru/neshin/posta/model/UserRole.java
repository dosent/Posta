package ru.neshin.posta.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<UserModel> users;
}
