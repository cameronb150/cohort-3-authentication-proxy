package com.authenticationproxy.authenticationproxy.repos;

import com.authenticationproxy.authenticationproxy.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorityRepo extends JpaRepository<Authority, Long> { }