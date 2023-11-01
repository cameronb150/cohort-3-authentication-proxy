package com.authenticationproxy.authenticationproxy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.authenticationproxy.authenticationproxy.models.User;
import com.authenticationproxy.authenticationproxy.repositories.UserRepository;


@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String ui() {
        return "redirect:/login";
    }
    @RequestMapping({"/home", "/login"})
    public String angularRouting() {
        return "forward:/index.html";
    }
//    @GetMapping("/home")
//    public String profile() {
//        return "forward:/index.html";
//    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }


    // TODO
    // Unsure how to get this working with limited permissions of capstone_user
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
        System.out.println("Saved new user!");
    }
}
