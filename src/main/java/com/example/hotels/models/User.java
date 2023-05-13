package com.example.hotels.models;

import com.example.hotels.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name="name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="role")
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Purchase> purchasesForUser;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "director", cascade = CascadeType.REMOVE)
    private List<Hotel> hotel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "director", cascade = CascadeType.REMOVE)

    private List<Purchase> purchasesForDirector;

    public boolean isUser() {
        return role.equals(Role.USER);
    }
    public boolean isDirector() {return role.equals(Role.ADMINISTRATOR);}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
