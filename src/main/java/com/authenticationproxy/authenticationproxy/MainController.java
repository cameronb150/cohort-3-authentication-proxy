package com.authenticationproxy.authenticationproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authenticationproxy.authenticationproxy.repos.AuthorityRepo;
import com.authenticationproxy.authenticationproxy.models.Authority;
import com.authenticationproxy.authenticationproxy.repos.UserRepo;
import com.authenticationproxy.authenticationproxy.models.User;

@RestController
public class MainController {
    @Autowired
    AuthorityRepo aRepo;
    @Autowired
    UserRepo uRepo;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        uRepo.save(user);
    }
}
