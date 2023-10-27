package com.authenticationproxy.authenticationproxy.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @Column(name = "user_roles")
    private Long id;
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Role role;
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
