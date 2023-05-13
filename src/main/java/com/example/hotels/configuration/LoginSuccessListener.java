package com.example.hotels.configuration;

import com.example.hotels.controllers.AppController;
import com.example.hotels.models.User;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final AppController appController;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent evt) {
        appController.user = (User) evt.getAuthentication().getPrincipal();
        System.out.println(appController.user.getUsername() + " has just logged in");

    }
}
