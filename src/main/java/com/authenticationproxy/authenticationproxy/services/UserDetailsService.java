package com.authenticationproxy.authenticationproxy.services;

import com.authenticationproxy.authenticationproxy.models.User;
import com.authenticationproxy.authenticationproxy.security.UserDetails;
import com.authenticationproxy.authenticationproxy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User (" + username + ") was not found"));
        return UserDetails.build(user);
    }
}
