package com.authenticationproxy.authenticationproxy.security;

import com.authenticationproxy.authenticationproxy.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final Long id;
    private final String username;
    private final String email;

    @JsonIgnore
    private final String password;
    private final Boolean isEnabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetails(Long id, String username, String email, String password, Boolean isEnabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    // Returns a compilation of every important data point for the User
    public static UserDetails build(User user) {
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());
        return new UserDetails(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(), // maybe change to get?
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    } // TODO
    @Override
    public boolean isAccountNonLocked() {
        return true;
    } // TODO
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // TODO
    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
