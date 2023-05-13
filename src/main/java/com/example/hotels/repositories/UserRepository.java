package com.example.hotels.repositories;

import com.example.hotels.enums.Role;
import com.example.hotels.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    List<User> findByRole(Role role);
}
