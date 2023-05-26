package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
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
    public String deleteUser(@PathVariable String id){
        Long longId= IdConverter.convert(id);
        userService.deleteUser(longId);
        return "login";
    }


    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("user", appController.user);
        return "user-info";
    }

    @GetMapping("/user/edit")
    public String editUser(Model model){
        model.addAttribute("user", appController.user);
        return "user-edit";
    }

    @PostMapping("/user/update")
    public String editingUser(User newUser){
        userService.editUser(newUser, appController.user);
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUserByRole(Role.USER));
        return "users";
    }

    @PostMapping("/user/{id}/set-role")
    public String setRole(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        userService.setDirectorRole(longId);
        return "redirect:/users";
    }
}
