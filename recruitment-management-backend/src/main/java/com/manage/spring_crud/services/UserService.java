package com.manage.spring_crud.services;

import com.manage.spring_crud.model.User;
import com.manage.spring_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //private BCryptPasswordEncoder passwordEncoder;



    public User loginUser(String username, String password) {

        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

        /*
        // Check if the provided password matches the stored encrypted password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password.");
        } */

        return user;
    }

}