package com.example.autopartsstore.controller;

import com.example.autopartsstore.entity.Role;
import com.example.autopartsstore.entity.User;
import com.example.autopartsstore.repository.UserRepository;
import com.example.autopartsstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        if (user != null) {
            userService.save(user);
        }
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
