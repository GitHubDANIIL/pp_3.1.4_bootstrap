package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/admin")
    public String pageForAuthenticatedUsers(Principal principal){
        return "secured part of wed service" + principal.getName();
    }
}
