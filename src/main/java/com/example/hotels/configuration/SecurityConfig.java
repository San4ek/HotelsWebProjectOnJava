package com.example.hotels.configuration;

import com.example.hotels.services.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
    private final CustomUserDetailService userDetailsService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/",
                        "/companies",
                        "/company/**",
                        "/countries",
                        "/country/**",
                        "/hotels",
                        "/hotel/**",
                        "/purchases",
                        "/purchase/**",
                        "/registration",
                        "/employees",
                        "/employee/**",
                        "/directors",
                        "/director/**",
                        "/jobs",
                        "/jobs/**",
                        "/purchases",
                        "/purchase/**",
                        "/user/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    /*@Bean
    public AuthenticationManager configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }*/
    /*@Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }*/

    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth ) throws Exception {
        return auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()).and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

}