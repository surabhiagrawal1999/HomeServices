package com.homeserve.homeserve.service;

import com.homeserve.homeserve.dto.LoginRequest;
import com.homeserve.homeserve.dto.UserRequest;
import com.homeserve.homeserve.model.User;
import com.homeserve.homeserve.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceCatalog {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceCatalog(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository= userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    public User newUser(UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        //The user gives me the raw password. Before I put it into the database, I pass it through the PasswordEncoder
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return user;
    }

    public String login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();

        return passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())?"Login Successful": "Password or Email is wrong";
    }
}
