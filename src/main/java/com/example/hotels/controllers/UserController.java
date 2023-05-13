package com.example.hotels.controllers;

import com.example.hotels.models.User;
import com.example.hotels.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AppController appController;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){ return "registration"; }


    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user))
        {
            model.addAttribute("errorMessage","Ошибка регистрации пользователя с логином: "+user.getLogin());
            return "registration";
        }
        return "redirect:/login";
    }

    @PostMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "login";
    }


    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id, Model model){
        model.addAttribute("user", appController.user);
        return "user-info";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user", appController.user);
        return "user-edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editingUser(@PathVariable Long id, User newUser){
        userService.editUser(id, newUser, appController.user);
        return "login";
    }
}
