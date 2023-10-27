package com.authenticationproxy.authenticationproxy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    @GetMapping("/")
    public String ui() {
        return "forward:/index.html";
    }
    @GetMapping("/profile")
    public String profile() {
        return "forward:/index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
