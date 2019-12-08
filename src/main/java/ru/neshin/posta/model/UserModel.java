package ru.neshin.posta.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "app_users")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "full_name", length = 64, nullable = false)
    private String name;
    @Column(name = "login", length = 10, nullable = false)
    private String login;
    @Column(name = "password", length = 64, nullable = false)
    private String password;
    @Column(name = "is_enabled", nullable = false)
    private boolean enabled;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;
}
