package com.example.hotels.controllers;

import com.example.hotels.models.User;
import com.example.hotels.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final UserService userService;
    public User user;

    @GetMapping("/")
    public String hotels(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "main-page";
    }
}
