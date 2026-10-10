package com.homeserve.homeserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
    //SecurityFilterChain = the set of rules Spring Security follows when an HTTP request arrives.
    httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
    return httpSecurity.build();
    }
}
