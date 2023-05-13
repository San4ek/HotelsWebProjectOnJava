package com.example.hotels.services;

import com.example.hotels.enums.Role;
import com.example.hotels.models.User;
import com.example.hotels.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        if(userRepository.findByLogin(user.getLogin())!=null){
            return false;
        }
        user.setRole(userRepository.findAll().isEmpty() ? Role.ADMINISTRATOR : Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user with login {}",user.getLogin());
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal==null)return new User();
        return userRepository.findByLogin(principal.getName());
    }

    public void editUser(Long id, User newUser, User olduser) {
        newUser.setId(id);
        newUser.setPassword(olduser.getPassword());
        newUser.setRole(olduser.getRole());
        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
