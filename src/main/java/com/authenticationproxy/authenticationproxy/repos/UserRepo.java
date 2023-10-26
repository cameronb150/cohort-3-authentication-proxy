package com.authenticationproxy.authenticationproxy.repos;

import com.authenticationproxy.authenticationproxy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long> { }