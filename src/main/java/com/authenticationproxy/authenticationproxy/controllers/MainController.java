package com.authenticationproxy.authenticationproxy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.authenticationproxy.authenticationproxy.models.User;
import com.authenticationproxy.authenticationproxy.repositories.UserRepository;

import com.authenticationproxy.authenticationproxy.security.SecurityConfig;
@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    SecurityConfig securityConfig;

    @GetMapping("/")
    public String ui() {
        return "redirect:/login";
    }
    @RequestMapping({"/home", "/login"})
    public String angularRouting() {
        return "forward:/index.html";
    }

    @GetMapping("/encode")
    public String encode(@RequestBody String password) {
        return securityConfig.getEncryptedPassword(password);
    }


    // TODO
    // Unsure how to get this working with limited permissions of capstone_user
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
        System.out.println("Saved new user!");
    }
}
