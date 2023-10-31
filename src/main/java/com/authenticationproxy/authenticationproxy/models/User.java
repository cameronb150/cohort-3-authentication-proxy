package com.authenticationproxy.authenticationproxy.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email_address")
})
public class User {
    @Id
    @Column(name="user_id", columnDefinition = "bigserial")
    private Long id;
    private String username;
    @Column(name = "email_address")
    private String email;
    private String password;
    @Column(name = "enabled")
    private boolean isEnabled;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();
}